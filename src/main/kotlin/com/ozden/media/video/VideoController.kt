package com.ozden.media.video

import com.ozden.media.video.summary.VideoInformationSummary
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/videos")
class VideoController(@Autowired val videoService: VideoService) {

    @GetMapping(value = ["/{videoId}/info"])
    fun getVideoInformationSummary(@PathVariable videoId: String) {
        // TODO: implement wih video id
    }

    @PostMapping("/info")
    fun retrieveVideoSummary(@RequestBody videoRequest: VideoRequest): VideoInformationSummary {
        return videoService.getVideoInformationSummary(videoRequest.url)
    }
}
