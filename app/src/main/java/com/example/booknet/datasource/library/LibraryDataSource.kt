package com.example.booknet.datasource.library

import androidx.lifecycle.MutableLiveData
import com.example.booknet.models.library.LibraryBookModel

object LibraryDataSource {
    val libraryBooks = MutableLiveData<List<LibraryBookModel>?>()
}