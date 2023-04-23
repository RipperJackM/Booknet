package com.example.booknet.repository.book


typealias GetBookChapterCallback = (status: BookChapterStatus) -> Unit

interface BookRepository {
    fun getBookChapters(bookId: String, completionHandler: GetBookChapterCallback)
}