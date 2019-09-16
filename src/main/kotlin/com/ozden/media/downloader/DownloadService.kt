package com.ozden.media.downloader

import com.ozden.media.downloader.command.CommandHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DownloadService(@Autowired var commandHelper: CommandHelper) {

    fun downloadVideo(url: String, formatCode: String?): Int {
        val command = commandHelper.prepareCommand(commandHelper.downloadVideo(url, formatCode))
        return command.execute().exitValue
    }
}
