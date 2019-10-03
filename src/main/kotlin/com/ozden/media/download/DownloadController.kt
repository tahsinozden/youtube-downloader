package com.ozden.media.download

import com.ozden.media.video.VideoRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/videos/download")
class DownloadController(@Autowired val downloadService: DownloadService) {

    @PostMapping(produces = [MediaType.APPLICATION_OCTET_STREAM_VALUE])
    fun downloadVideo(@RequestBody videoRequest: VideoRequest): ByteArray {
        return downloadService.downloadAndServeVideo(videoRequest.url, videoRequest.formatIds ?: emptyList())
    }
}
