package com.ozden.media.downloader.video.summary

import com.ozden.media.downloader.video.generated.Format

data class VideoInformationSummary(val url: String, val name: String, val channelId: String, val formats: List<FormatSummary>)
