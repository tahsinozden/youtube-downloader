package com.ozden.media.downloader.command

import com.ozden.media.downloader.DownloadService
import org.junit.Assert.assertEquals
import org.junit.Test

class DownloadServiceTest {

    private val commandHelper = CommandHelper("src/main/resources/bin/youtube-dl")
    private val downloadService = DownloadService(commandHelper)
    private val URL = "https://www.youtube.com/watch?v=3W0EfZixEaE"

    @Test
    fun shouldDownloadVideo() {
        val actual = downloadService.downloadVideo(URL, "22")
        assertEquals(0, actual)
    }

    @Test
    fun shouldDownloadBestVideoFormatAvailable() {
        val actual = downloadService.downloadVideo(URL, null)
        assertEquals(0, actual)
    }
}
