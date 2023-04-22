package com.example.booknet.network

sealed class ApiResult {
    class Success(val objectModel: String) : ApiResult()
    class Failure(val errorModel: String) : ApiResult()
    class FailureHttp(val errorMessage: String) : ApiResult()
}