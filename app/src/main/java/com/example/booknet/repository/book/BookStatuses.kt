package com.example.booknet.repository.book

import com.example.booknet.apimodels.response.ApiResponseError
import com.example.booknet.models.book.BookChapterModel

sealed class BookChapterStatus {
    class ApiError(val errorModel: ApiResponseError) : BookChapterStatus()
    class HttpError(val error: String) : BookChapterStatus()
    data class Success(val chapters: List<BookChapterModel>) : BookChapterStatus()
}