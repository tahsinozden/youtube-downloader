package com.ozden.media.download

import com.ozden.media.command.CommandHelper
import org.junit.After
import org.junit.Assert.*
import org.junit.Test
import java.io.File

class DownloadServiceTest {

    private val commandHelper = CommandHelper("src/main/resources/bin/youtube-dl", "src/main/resources/downloaded")
    private val downloadService = DownloadService(commandHelper)
    private val URL = "https://www.youtube.com/watch?v=668nUCeBHyY"

    @After
    fun postProcess() {
        val folder = File(commandHelper.downloadDirectory)
        assertTrue(folder.listFiles().isEmpty())
    }

    @Test
    fun shouldDownloadVideo() {
        val actual = downloadService.downloadVideo(URL, arrayListOf("22"), "file1")
        deleteFile("file1")
        assertEquals(0, actual)
    }

    @Test
    fun shouldDownloadBestVideoFormatAvailable() {
        val actual = downloadService.downloadVideo(URL, emptyList(), "file2")
        deleteFile("file2.mp4")
        assertEquals(0, actual)
    }

    @Test
    fun shouldRetrieveDownloadedVideoStreamBytes() {
        val actual = downloadService.downloadAndServeVideo(URL, arrayListOf("22"))
        assertNotEquals(0, actual.size)
    }

    private fun deleteFile(fileName: String) = File(commandHelper.toFullPath(fileName)).delete()
}
