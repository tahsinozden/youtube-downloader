package com.ozden.media.download

import com.ozden.media.command.CommandHelper
import com.ozden.media.video.VideoService
import com.ozden.media.video.summary.FormatSummary
import com.ozden.media.video.summary.VideoInformationSummary
import org.junit.After
import org.junit.Assert.*
import org.junit.Test
import java.io.File
import java.nio.file.Files

class DownloadServiceTest {

    private val commandHelper = CommandHelper("src/main/resources/bin/youtube-dl", "src/main/resources/downloaded")
    private val videoService = VideoService(commandHelper)
    private val downloadService = DownloadService(commandHelper, videoService)
    private val URL = "https://www.youtube.com/watch?v=668nUCeBHyY"

    @After
    fun postProcess() {
        val folder = File(commandHelper.downloadDirectory)
        folder.listFiles().forEach { file -> Files.deleteIfExists(file.toPath()) }
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

    @Test
    fun shouldCheckAndSortFormatIdsAsVideoFirstAndTheAudiosLater() {
        // given
        val formatSummaries = listOf(
                FormatSummary("", 1, "audio only", "249", "", 24, ""),
                FormatSummary("", 1, "video only", "350", "", 24, "")
        )
        val videoInformationSummary = VideoInformationSummary("url", "name", "id", formatSummaries)
        val formatIds = listOf("249", "350")

        // when
        val actual = downloadService.checkAndSortFormatIds(formatIds, videoInformationSummary)

        // then
        assertTrue(actual.size == 2)
        assertTrue(actual[0] == "350")
        assertTrue(actual[1] == "249")
    }

    private fun deleteFile(fileName: String) = File(commandHelper.toFullPath(fileName)).delete()
}
