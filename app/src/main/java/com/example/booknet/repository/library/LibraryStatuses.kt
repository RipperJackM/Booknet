package com.example.booknet.repository.library

import com.example.booknet.apimodels.response.ApiResponseError
import com.example.booknet.models.library.LibraryBookModel

sealed class EmptyLibraryStatus {
    class ApiError(val errorModel: ApiResponseError) : EmptyLibraryStatus()
    class HttpError(val error: String) : EmptyLibraryStatus()
    object Success : EmptyLibraryStatus()
}

sealed class BaseLibraryStatus {
    class ApiError(val errorModel: ApiResponseError) : BaseLibraryStatus()
    class HttpError(val error: String) : BaseLibraryStatus()
    data class Success(val libraryBooksList: List<LibraryBookModel>) : BaseLibraryStatus()
}