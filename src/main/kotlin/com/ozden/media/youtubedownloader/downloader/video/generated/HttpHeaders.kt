package com.ozden.media.youtubedownloader.downloader.video.generated


import com.google.gson.annotations.SerializedName

data class HttpHeaders(
    @SerializedName("Accept")
    val accept: String,
    @SerializedName("Accept-Charset")
    val acceptCharset: String,
    @SerializedName("Accept-Encoding")
    val acceptEncoding: String,
    @SerializedName("Accept-Language")
    val acceptLanguage: String,
    @SerializedName("User-Agent")
    val userAgent: String
)
