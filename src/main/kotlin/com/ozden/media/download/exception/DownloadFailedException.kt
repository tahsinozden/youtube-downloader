package com.ozden.media.download.exception

import java.lang.RuntimeException

class DownloadFailedException(override val message: String?) : RuntimeException(message) {
}