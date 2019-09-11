package com.ozden.media.youtubedownloader.downloader.command

import org.junit.Assert.assertEquals
import org.junit.Test

class CommandServiceTest {

    private val commandHelper = CommandHelper("src/main/resources/bin/youtube-dl")
    private val commandService = CommandService(commandHelper)
    private val URL = "https://www.youtube.com/watch?v=3W0EfZixEaE"

    @Test
    fun shouldGetVideoInformation() {
        var actual = commandService.getVideoInformation(URL)
        actual.formats.forEach{ item -> println(item)}
        assertEquals(22, actual.formats.size)
    }

    @Test
    fun shouldDownloadVideo() {
        val actual = commandService.downloadVideo(URL, "22")
        assertEquals(0, actual)
    }
}
