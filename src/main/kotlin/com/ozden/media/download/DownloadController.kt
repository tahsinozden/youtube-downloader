package com.ozden.media.download

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController(value = "/api/v1/videos/download")
class DownloadController(@Autowired val downloadService: DownloadService) {


}
