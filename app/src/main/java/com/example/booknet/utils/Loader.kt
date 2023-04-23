package com.example.booknet.utils

import androidx.lifecycle.MutableLiveData

object Loader {
    val isLoading = MutableLiveData(false)
    fun isLoading(loading: Boolean) {
        isLoading.postValue(loading)
    }
}