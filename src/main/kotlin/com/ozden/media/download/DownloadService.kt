package com.ozden.media.download

import com.ozden.media.command.CommandHelper
import com.ozden.media.download.exception.DownloadFailedException
import com.ozden.media.video.VideoService
import com.ozden.media.video.summary.VideoInformationSummary
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileNotFoundException
import java.util.*

@Service
class DownloadService(@Autowired var commandHelper: CommandHelper, @Autowired var videoService: VideoService) {

    val logger = LoggerFactory.getLogger(DownloadService::class.simpleName)

    fun downloadAndServeVideo(url: String, formatIds: List<String>): ByteArray {
        var outputFileName = UUID.randomUUID().toString()
        downloadVideo(url, formatIds, outputFileName)
        return retrieveFileContent(outputFileName)
    }

    fun downloadVideo(url: String, formatIds: List<String>, outputFileName: String): Int {
        val videoInfoSummary = videoService.getVideoInformationSummary(url)
        val sortedFormatIds = checkAndSortFormatIds(formatIds, videoInfoSummary)
        val command = commandHelper.cmdDownloadVideo(url, sortedFormatIds, outputFileName)
        val processResult = command.execute()
        if (!isDownloadSuccess(processResult.exitValue)) {
            throw DownloadFailedException(processResult.outputUTF8())
        }
        return command.execute().exitValue
    }

    fun checkAndSortFormatIds(formatIds: List<String>, videoInfoSummary: VideoInformationSummary): List<String> {
        val sortedFormatIds = LinkedList<String>()
        val supportedFormatSummaryById = videoInfoSummary.formats.map { it.formatId to it }.toMap()

        for (formatId in formatIds) {
            val format = supportedFormatSummaryById[formatId] ?: continue
            if (format.format.contains("audio")) {
                sortedFormatIds.addLast(formatId)
                continue
            }
            sortedFormatIds.addFirst(formatId)
        }

        return sortedFormatIds;
    }

    private fun retrieveFileContent(fileName: String): ByteArray {
        val name = commandHelper.retrieveRealFileName(fileName)
        val file = File(commandHelper.toFullPath(name ?: throw FileNotFoundException(fileName)))
        val copiedFileData = file.readBytes().copyOf()
        file.delete()
        return copiedFileData
    }

    private fun isDownloadSuccess(code: Int): Boolean {
        return code == 0
    }
}
