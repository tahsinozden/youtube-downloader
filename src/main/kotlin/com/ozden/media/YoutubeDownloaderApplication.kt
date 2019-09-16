package com.ozden.media

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class YoutubeDownloaderApplication

fun main(args: Array<String>) {
	runApplication<YoutubeDownloaderApplication>(*args)
}
