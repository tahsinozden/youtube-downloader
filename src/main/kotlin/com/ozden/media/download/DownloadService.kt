package com.ozden.media.download

import com.ozden.media.command.CommandHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File
import java.util.*

@Service
class DownloadService(@Autowired var commandHelper: CommandHelper,
                      @Value("\${downloader.download.directory}") var downloadDirectory: String) {

    fun downloadAndServeVideo(url: String, formatIds: List<String>): ByteArray {
        val outputFileName = UUID.randomUUID().toString()
        val statusCode = downloadVideo(url, formatIds, outputFileName)
        if (!isDownloadSuccess(statusCode)) {
            // TODO: throw proper exception
            return ByteArray(0)
        }
        val fileName = outputFileName.replace("\n", "")
       return File("$downloadDirectory/$fileName").readBytes()
    }

    fun downloadVideo(url: String, formatIds: List<String>, outputFileName: String): Int {
        val command = commandHelper.cmdDownloadVideo(url, formatIds, outputFileName)
        return command.execute().exitValue
    }

    private fun isDownloadSuccess(code: Int): Boolean {
        return code == 0
    }
}
