package com.ozden.media.command

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.zeroturnaround.exec.ProcessExecutor
import java.io.File
import java.nio.file.Path


@Component
class CommandHelper(@Value("\${downloader.binary.path}") var downloaderBinaryPath: String,
                    @Value("\${downloader.download.directory}") var downloadDirectory: String) {

    private val processExecutor = ProcessExecutor()

    fun cmdJsonData(url: String) = prepareCommand(listOf(downloaderBinaryPath, Command.SIMULATE.value, Command.GET_JSON_DATA.value, url))

    fun cmdDownloadVideo(url: String, formatIds: List<String>, outputFileName: String): ProcessExecutor {
        val args = arrayListOf(downloaderBinaryPath, url, Command.OUTPUT.value, "$downloadDirectory/$outputFileName")
        if (formatIds.isNotEmpty()) {
            args.addAll(listOf(Command.DOWNLOAD.value, formatIds.joinToString("+")))
        }
        return prepareCommand(args)
    }

    fun toFullPath(fileName: String) = Path.of(downloadDirectory, fileName).toString()

    fun retrieveRealFileName(fileName: String): String? {
        val folder = File(downloadDirectory)
        for (file in folder.listFiles()) {
            if (file.name.startsWith(fileName)) {
                return file.name
            }
        }
        return null
    }

    private fun prepareCommand(args: List<String>): ProcessExecutor {
        val command = processExecutor.command(args)
        command.readOutput(true)
        return command
    }

}
