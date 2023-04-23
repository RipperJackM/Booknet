package com.example.booknet.ui.flow.home.iread

import androidx.lifecycle.ViewModel
import com.example.booknet.datasource.library.LibraryDataSource

class IReadViewModel: ViewModel() {
    fun getItemList() = LibraryDataSource.iReadBooks
    fun isListEmpty() = getItemList().value.isNullOrEmpty()
}