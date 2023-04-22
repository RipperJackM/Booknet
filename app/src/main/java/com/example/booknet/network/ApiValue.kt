package com.example.booknet.network

import com.example.booknet.constants.ApiConstants

enum class ApiRequestType {
    Get, GetWithParams, Post, PostMultipart, Put, Delete
}

class ApiValue(path: String, requestType: ApiRequestType) {
    val path: String
    val type: ApiRequestType = requestType

    init {
        this.path = "${ApiConstants.baseUrl}$path"
    }
}