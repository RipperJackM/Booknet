package com.example.booknet.network.book

import com.example.booknet.api.ApiResponseGetBookChapter
import com.example.booknet.api.book.BookApi
import com.example.booknet.network.ApiService
import com.example.booknet.network.DataFetcher

class BookDataFetcher(private val apiService: ApiService) : DataFetcher() {

    fun getBookChapters(
        bookId: String,
        appName: String,
        deviceId: String,
        token: String,
        apiVersion: String,
        sign: String,
        completionHandler: ApiResponseGetBookChapter
    ) {
        apiService.procedure(
            api = BookApi.GetBookChapter(bookId, appName, deviceId, token, apiVersion, sign),
            completionHandler = callback(completionHandler)
        )
    }
}