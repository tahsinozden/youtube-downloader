package com.ozden.media.command

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.zeroturnaround.exec.ProcessExecutor

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

    private fun prepareCommand(args: List<String>): ProcessExecutor {
        val command = processExecutor.command(args)
        command.readOutput(true)
        return command
    }

}
