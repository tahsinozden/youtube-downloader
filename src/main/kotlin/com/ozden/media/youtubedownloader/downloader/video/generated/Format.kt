package com.ozden.media.youtubedownloader.downloader.video.generated


import com.google.gson.annotations.SerializedName

data class Format(
        val abr: Int,
        val acodec: String,
        val asr: Int?,
        val container: String,
        @SerializedName("downloader_options")
    val downloaderOptions: DownloaderOptions,
        val ext: String,
        val filesize: Int?,
        val format: String,
        @SerializedName("format_id")
    val formatId: String,
        @SerializedName("format_note")
    val formatNote: String,
        val fps: Int?,
        val height: Int?,
        @SerializedName("http_headers")
    val httpHeaders: HttpHeaders,
        @SerializedName("player_url")
    val playerUrl: Any?,
        val protocol: String,
        val quality: Int,
        val tbr: Double,
        val url: String,
        val vcodec: String,
        val width: Int?
)
