package com.ozden.media.downloader.video

import com.google.gson.Gson
import com.ozden.media.downloader.command.CommandHelper
import com.ozden.media.downloader.video.generated.Format
import com.ozden.media.downloader.video.generated.VideoInformation
import com.ozden.media.downloader.video.summary.FormatSummary
import com.ozden.media.downloader.video.summary.VideoInformationSummary
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class VideoService(@Autowired val commandHelper: CommandHelper) {

    fun getVideoInformation(url: String): VideoInformation {
        val command = commandHelper.prepareCommand(commandHelper.jsonData(url))
        val output = command.execute().outputString()
        return Gson().fromJson(output, VideoInformation::class.java)
    }

    fun getVideoInformationSummary(url: String): VideoInformationSummary {
        val videoInformation = getVideoInformation(url)
        return VideoInformationSummary(url, videoInformation.filename, videoInformation.channelId, extractFormatInfo(videoInformation.formats))
    }

    private fun extractFormatInfo(formats: List<Format>): List<FormatSummary> {
        return formats.stream().map { f -> FormatSummary(f.ext, f.filesize, f.format, f.formatId, f.formatNote, f.fps, f.url) }.collect(Collectors.toList())
    }
}
