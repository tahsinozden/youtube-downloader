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
        val command = processExecutor.command(commandHelper.jsonData(url))
        command.readOutput(true)
        val output = command.execute().outputString()
        return Gson().fromJson(output, VideoInformation::class.java)
    }

}
