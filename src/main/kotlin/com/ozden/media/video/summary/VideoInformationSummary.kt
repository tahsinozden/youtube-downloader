package com.ozden.media.video.summary

data class VideoInformationSummary(val url: String, val name: String, val channelId: String, val formats: List<FormatSummary>)
