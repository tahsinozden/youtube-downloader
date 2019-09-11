package com.ozden.media.youtubedownloader.downloader.command

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class CommandHelper(@Value("\${downloader.binary.path}") var downloaderBinaryPath: String) {

    fun jsonData(url: String) = listOf(downloaderBinaryPath, Command.SIMULATE.value, Command.GET_JSON_DATA.value, url)

    fun downloadVideo(url: String, formatCode: String) = listOf(downloaderBinaryPath, url, Command.DOWNLOAD.value, formatCode)

}
