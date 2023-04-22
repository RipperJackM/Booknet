package com.example.booknet.network

import com.example.booknet.api.DataResult
import com.example.booknet.apimodels.response.ApiResponseError
import com.google.gson.Gson

open class DataFetcher {
    internal inline fun <reified T : Any> callback(crossinline completionHandler: (DataResult<T>) -> Unit): ApiResponse {
        return { apiResult ->
            val result = when (apiResult) {
                is ApiResult.FailureHttp -> DataResult.FailureHttp(apiResult.errorMessage)
                is ApiResult.Failure -> {
                    try {
                        val errorModel =
                            Gson().fromJson(apiResult.errorModel, ApiResponseError::class.java)
                        DataResult.Failure(errorModel)
                    } catch (ex: Exception) {
                        DataResult.FailureHttp("cannot convert ${apiResult.errorModel}")
                    }
                }
                is ApiResult.Success -> {
                    try {
                        DataResult.Success(Gson().fromJson(apiResult.objectModel, T::class.java))
                    } catch (ex: Exception) {
                        try {
                            DataResult.Success(
                                Gson().fromJson(
                                    "{ \"result\" : ${apiResult.objectModel} }",
                                    T::class.java
                                )
                            )
                        } catch (e: Exception) {
                            DataResult.FailureHttp("cannot convert ${apiResult.objectModel}")
                        }
                    }
                }
            }
            completionHandler(result)
        }
    }
}