package com.ozden.media.video.summary


data class FormatSummary(
    val ext: String,
    val filesize: Int?,
    val format: String,
    val formatId: String,
    val formatNote: String,
    val fps: Int?,
    val url: String
)
