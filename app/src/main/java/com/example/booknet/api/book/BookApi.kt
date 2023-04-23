package com.example.booknet.api.book

import com.example.booknet.network.API
import com.example.booknet.network.ApiRequestType
import com.example.booknet.network.ApiValue

class BookApi {

    class GetBookChapter(
        bookId: String,
        appName: String,
        deviceId: String,
        token: String,
        apiVersion: String,
        sign: String
    ) : API(
        ApiValue(
            "book/get-text/$bookId?app=$appName&device_id=$deviceId&user_token=$token&sign=$sign&version=$apiVersion",
            ApiRequestType.Get
        )
    )
}