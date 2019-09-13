package com.ozden.media.youtubedownloader.downloader.command

import com.google.gson.Gson
import com.ozden.media.youtubedownloader.downloader.video.generated.VideoInformation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.zeroturnaround.exec.ProcessExecutor

@Service
class CommandService(@Autowired var commandHelper: CommandHelper) {

    private val processExecutor = ProcessExecutor()

    fun getVideoInformation(url: String): VideoInformation {
        val command = prepareCommand(commandHelper.jsonData(url))
        val output = command.execute().outputString()
        return Gson().fromJson(output, VideoInformation::class.java)
    }

    fun downloadVideo(url: String, formatCode: String?): Int {
        val command = prepareCommand(commandHelper.downloadVideo(url, formatCode))
        return command.execute().exitValue
    }

    private fun prepareCommand(args: List<String>): ProcessExecutor {
        val command = processExecutor.command(args)
        command.readOutput(true)
        return command
    }

}
