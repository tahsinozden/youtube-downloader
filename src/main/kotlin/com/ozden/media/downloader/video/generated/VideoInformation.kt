package com.ozden.media.downloader.video.generated


import com.google.gson.annotations.SerializedName

data class VideoInformation(
        val abr: Int,
        val acodec: String,
        @SerializedName("age_limit")
    val ageLimit: Int,
        val album: Any?,
        @SerializedName("alt_title")
    val altTitle: Any?,
        val annotations: Any?,
        val artist: Any?,
        val asr: Int,
        @SerializedName("automatic_captions")
    val automaticCaptions: AutomaticCaptions,
        @SerializedName("average_rating")
    val averageRating: Double,
        val categories: List<String>,
        @SerializedName("channel_id")
    val channelId: String,
        @SerializedName("channel_url")
    val channelUrl: String,
        val chapters: Any?,
        val creator: Any?,
        val description: String,
        @SerializedName("dislike_count")
    val dislikeCount: Int,
        @SerializedName("display_id")
    val displayId: String,
        val duration: Int,
        @SerializedName("end_time")
    val endTime: Any?,
        @SerializedName("episode_number")
    val episodeNumber: Any?,
        val ext: String,
        val extractor: String,
        @SerializedName("extractor_key")
    val extractorKey: String,
        @SerializedName("_filename")
    val filename: String,
        val filesize: Any?,
        val format: String,
        @SerializedName("format_id")
    val formatId: String,
        @SerializedName("format_note")
    val formatNote: String,
        val formats: List<Format>,
        val fps: Any?,
        val fulltitle: String,
        val height: Int,
        @SerializedName("http_headers")
    val httpHeaders: HttpHeadersX,
        val id: String,
        @SerializedName("is_live")
    val isLive: Any?,
        val license: String,
        @SerializedName("like_count")
    val likeCount: Int,
        @SerializedName("player_url")
    val playerUrl: Any?,
        val playlist: Any?,
        @SerializedName("playlist_index")
    val playlistIndex: Any?,
        val protocol: String,
        val quality: Int,
        @SerializedName("release_date")
    val releaseDate: Any?,
        @SerializedName("release_year")
    val releaseYear: Any?,
        @SerializedName("requested_subtitles")
    val requestedSubtitles: Any?,
        @SerializedName("season_number")
    val seasonNumber: Any?,
        val series: Any?,
        @SerializedName("start_time")
    val startTime: Any?,
        val subtitles: Subtitles,
        val tags: List<String>,
        val tbr: Double,
        val thumbnail: String,
        val thumbnails: List<Thumbnail>,
        val title: String,
        val track: Any?,
        @SerializedName("upload_date")
    val uploadDate: String,
        val uploader: String,
        @SerializedName("uploader_id")
    val uploaderId: String,
        @SerializedName("uploader_url")
    val uploaderUrl: String,
        val url: String,
        val vcodec: String,
        @SerializedName("view_count")
    val viewCount: Int,
        @SerializedName("webpage_url")
    val webpageUrl: String,
        @SerializedName("webpage_url_basename")
    val webpageUrlBasename: String,
        val width: Int
)
