package com.ozden.media.download

import com.ozden.media.video.VideoRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/videos/download")
class DownloadController(@Autowired val downloadService: DownloadService) {

    @PostMapping(produces = [MediaType.APPLICATION_OCTET_STREAM_VALUE])
    fun downloadVideo(@RequestBody videoRequest: VideoRequest): ByteArray {
        return downloadService.downloadAndServeVideo(videoRequest.url, videoRequest.formatIds ?: emptyList())
    }

    @GetMapping(produces = [MediaType.APPLICATION_OCTET_STREAM_VALUE])
    fun downloadVideoGet(@RequestParam url: String, @RequestParam formatIds: List<String>): ByteArray {
        return downloadService.downloadAndServeVideo(url, formatIds)
    }

}
