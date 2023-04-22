package com.example.booknet.network

import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

typealias ApiParameters = HashMap<String, *>
typealias ApiResponse = ((ApiResult) -> Unit)

class ApiService(private val client: OkHttpClient) {

    private var json = "application/json; charset=utf-8".toMediaTypeOrNull()

    fun procedure(
        api: API,
        params: BaseRequestParams? = null,
        multipartParams: MultipartBody? = null,
        withObject: Boolean = false,
        completionHandler: ApiResponse
    ) {
        val request = api.apiValue
        val parameters = params?.parameters ?: hashMapOf<String, String>()
        when (request.type) {
            ApiRequestType.Get -> get(
                url = request.path,
                callback = generateCallback(completionHandler)
            )
            ApiRequestType.GetWithParams -> getWithParams(
                url = request.path,
                parameters = parameters,
                callback = generateCallback(completionHandler)
            )
            ApiRequestType.Post -> post(
                url = request.path,
                parameters = parameters,
                withObject = withObject,
                callback = generateCallback(completionHandler)
            )
            ApiRequestType.PostMultipart -> postMultipart(
                url = request.path,
                multipartBody = multipartParams!!,
                callback = generateCallback(completionHandler)
            )
            ApiRequestType.Put -> put(
                url = request.path,
                parameters = parameters,
                callback = generateCallback(completionHandler)
            )
            ApiRequestType.Delete -> delete(
                url = request.path,
                parameters = parameters,
                callback = generateCallback(completionHandler)
            )
        }
    }

    private fun generateCallback(completionHandler: ApiResponse): Callback {
        return object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string() ?: ""
                if (response.code in 200..299) {
                    completionHandler(ApiResult.Success(body))
                } else {
                    completionHandler(ApiResult.Failure(body))
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                completionHandler(ApiResult.FailureHttp(e.message ?: "Failure http"))
            }
        }
    }

    private fun generateFormBody(parameters: ApiParameters, withObject: Boolean): RequestBody {
        return if (withObject) Gson().toJson(parameters).toRequestBody(json)
        else JSONObject(parameters).toString().toRequestBody(json)
    }

    private fun get(
        url: String,
        callback: Callback
    ): Call {
        val request = Request.Builder()
            .url(url)
            .get()

        val call = client.newCall(request.build())
        call.enqueue(callback)
        return call
    }

    private fun getWithParams(
        url: String,
        parameters: ApiParameters,
        callback: Callback
    ): Call {
        val params = parameters.map { it.key + "=" + it.value.toString() }.joinToString("&")
        val request = Request.Builder()
            .url("$url?$params")
            .get()
        val call = client.newCall(request.build())
        call.enqueue(callback)
        return call
    }

    private fun post(
        url: String,
        parameters: ApiParameters,
        withObject: Boolean,
        callback: Callback
    ): Call {
        val request = Request.Builder()
            .url(url)

        request.post(generateFormBody(parameters, withObject))

        val call = client.newCall(request.build())
        call.enqueue(callback)
        return call
    }

    private fun postMultipart(
        url: String,
        multipartBody: MultipartBody,
        callback: Callback
    ): Call {
        val request = Request.Builder()
            .url(url)

        request.post(multipartBody)

        val call = client.newCall(request.build())
        call.enqueue(callback)
        return call
    }

    private fun put(
        url: String,
        parameters: ApiParameters,
        callback: Callback
    ): Call {
        val request = Request.Builder()
            .url(url)
            .put(generateFormBody(parameters, false))

        val call = client.newCall(request.build())
        call.enqueue(callback)
        return call
    }

    private fun delete(
        url: String,
        parameters: ApiParameters,
        callback: Callback
    ): Call {
        val request = Request.Builder()
            .url(url)
            .delete(generateFormBody(parameters, false))

        val call = client.newCall(request.build())
        call.enqueue(callback)
        return call
    }
}