package com.example.booknet.api.library

import com.example.booknet.network.API
import com.example.booknet.network.ApiRequestType
import com.example.booknet.network.ApiValue

class LibraryApi {

    class GetBooks(
        appName: String,
        deviceId: String,
        token: String,
        apiVersion: String,
        sign: String
    ) : API(
        ApiValue(
            "library/get?app=$appName&device_id=$deviceId&user_token=$token&sign=$sign&version=$apiVersion",
            ApiRequestType.Get
        )
    )
}