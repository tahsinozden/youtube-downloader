package com.ozden.media.download

import com.ozden.media.command.CommandHelper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class DownloadServiceTest {

    private val commandHelper = CommandHelper("src/main/resources/bin/youtube-dl", "/home/tahsin/Documents/downloaded")
    private val downloadService = DownloadService(commandHelper)
    private val URL = "https://www.youtube.com/watch?v=668nUCeBHyY"

    @Test
    fun shouldDownloadVideo() {
        val actual = downloadService.downloadVideo(URL, arrayListOf("22"), "file1")
        assertEquals(0, actual)
    }

    @Test
    fun shouldDownloadBestVideoFormatAvailable() {
        val actual = downloadService.downloadVideo(URL, emptyList(), "file2")
        assertEquals(0, actual)
    }

    @Test
    fun shouldRetrieveDownloadedVideoStreamBytes() {
        val actual = downloadService.downloadAndServeVideo(URL, arrayListOf("22"))
        assertNotEquals(0, actual.size)
    }
}
