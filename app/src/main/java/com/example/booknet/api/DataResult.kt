package com.example.booknet.api

import com.example.booknet.apimodels.response.ApiResponseError
import com.example.booknet.apimodels.response.book.BookChapterResponse
import com.example.booknet.apimodels.response.library.LibraryBooksResponse

sealed class DataResult<out T : Any> {
    class Success<out T : Any>(val data: T) : DataResult<T>()
    class Failure(val errorModel: ApiResponseError) : DataResult<Nothing>()
    class FailureHttp(val error: String) : DataResult<Nothing>()
}

// Library
typealias ApiResponseGetLibraryBooks = (DataResult<LibraryBooksResponse>) -> Unit

// Book
typealias ApiResponseGetBookChapter = (DataResult<BookChapterResponse>) -> Unit