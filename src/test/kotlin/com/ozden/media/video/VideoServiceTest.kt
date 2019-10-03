package com.ozden.media.video

import com.ozden.media.command.CommandHelper
import org.junit.Assert.assertEquals
import org.junit.Test

class VideoServiceTest {

    private val commandHelper = CommandHelper("src/main/resources/bin/youtube-dl", "")
    private val videoService = VideoService(commandHelper)
    private val URL = "https://www.youtube.com/watch?v=668nUCeBHyY"

    @Test
    fun shouldGetVideoInformation() {
        val actual = videoService.getVideoInformation(URL)
        actual.formats.forEach{ item -> println(item)}
        assertEquals(17, actual.formats.size)
    }

}
