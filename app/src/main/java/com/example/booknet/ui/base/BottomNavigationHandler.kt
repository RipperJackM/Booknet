package com.example.booknet.ui.base

import androidx.lifecycle.MutableLiveData

object BottomNavigationHandler {
    val isVisible = MutableLiveData(false)
    fun isNeedToShow(loading: Boolean) {
        isVisible.postValue(loading)
    }
}