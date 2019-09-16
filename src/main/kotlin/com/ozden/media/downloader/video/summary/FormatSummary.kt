package com.ozden.media.downloader.video.summary


import com.google.gson.annotations.SerializedName

data class FormatSummary(
    val ext: String,
    val filesize: Int?,
    val format: String,
    val formatId: String,
    val formatNote: String,
    val fps: Int?,
    val url: String
)
