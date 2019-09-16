package com.ozden.media.download

import com.ozden.media.video.VideoRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/videos/download")
class DownloadController(@Autowired val downloadService: DownloadService) {

    @PostMapping
    fun downloadVideo(@RequestBody videoRequest: VideoRequest) {
        downloadService.downloadVideo(videoRequest.url, videoRequest.formatIds)
    }
}
