package com.ozden.media.command

enum class Command(val value: String) {

    LIST_DOWNLOAD_ITEMS("-F"),
    GET_JSON_DATA("--print-json"),
    SIMULATE("-s"),
    DOWNLOAD("-f")
}
