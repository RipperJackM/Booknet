package com.example.booknet.network.library

import com.example.booknet.api.ApiResponseGetLibraryBooks
import com.example.booknet.api.library.LibraryApi
import com.example.booknet.network.ApiService
import com.example.booknet.network.DataFetcher

class LibraryDataFetcher(private val apiService: ApiService) : DataFetcher() {

    fun getBooks(
        appName: String,
        deviceId: String,
        token: String,
        apiVersion: String,
        sign: String,
        completionHandler: ApiResponseGetLibraryBooks
    ) {
        apiService.procedure(
            api = LibraryApi.GetBooks(appName, deviceId, token, apiVersion, sign),
            completionHandler = callback(completionHandler)
        )
    }
}