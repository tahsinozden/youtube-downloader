package com.ozden.media.download

import com.ozden.media.command.CommandHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DownloadService(@Autowired var commandHelper: CommandHelper) {

    fun downloadVideo(url: String, formatId: List<String>): Int {
        val command = commandHelper.prepareCommand(commandHelper.cmdDownloadVideo(url, formatId))
        return command.execute().exitValue
    }
}
