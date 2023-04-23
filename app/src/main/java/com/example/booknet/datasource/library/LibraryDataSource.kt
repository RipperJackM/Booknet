package com.example.booknet.datasource.library

import androidx.lifecycle.MutableLiveData
import com.example.booknet.models.library.LibraryBookModel

enum class LibraryType(val key: Int) {
    LIBRARY_TYPE_GENERAL(-1),
    LIBRARY_TYPE_READ(0),
    LIBRARY_TYPE_ARCHIVE(1),
    LIBRARY_TYPE_FAVOURITE(2)
}

object LibraryDataSource {

    val libraryBooks = MutableLiveData<List<LibraryBookModel>?>()
    val iReadBooks = MutableLiveData<List<LibraryBookModel>?>()
    val favouriteBooks = MutableLiveData<List<LibraryBookModel>?>()
    val archiveBooks = MutableLiveData<List<LibraryBookModel>?>()
}