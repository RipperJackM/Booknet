package com.example.booknet.models.book

class BookChapterModel(
    val id: Long,
    val access: Boolean,
    val text: String?,
) {

    val textPerPage: List<String>
    get() = text?.chunked(5000) ?: listOf()
}

