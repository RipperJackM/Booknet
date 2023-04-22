package com.example.booknet.apimodels.response

import com.example.booknet.apimodels.response.ApiResponseVoid

class ApiResponseError : ApiResponseVoid() {
    val message: String = ""
    val error: String
        get() {
            return code
        }
}