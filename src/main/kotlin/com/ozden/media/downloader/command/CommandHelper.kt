package com.ozden.media.downloader.command

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.zeroturnaround.exec.ProcessExecutor

@Component
class CommandHelper(@Value("\${downloader.binary.path}") var downloaderBinaryPath: String) {

    private val processExecutor = ProcessExecutor()

    fun jsonData(url: String) = listOf(downloaderBinaryPath, Command.SIMULATE.value, Command.GET_JSON_DATA.value, url)

    fun downloadVideo(url: String, formatCode: String?): List<String> {
        val args = arrayListOf(downloaderBinaryPath, url)
        formatCode?.let {
            args.addAll(listOf(Command.DOWNLOAD.value, formatCode))
        }
        return args
    }

    fun prepareCommand(args: List<String>): ProcessExecutor {
        val command = processExecutor.command(args)
        command.readOutput(true)
        return command
    }

}
