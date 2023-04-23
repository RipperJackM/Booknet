package com.example.booknet.ui.flow.home.library

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.booknet.datasource.library.LibraryDataSource
import com.example.booknet.models.book.BookChapterModel
import com.example.booknet.repository.book.BookChapterStatus
import com.example.booknet.repository.book.BookRepository
import com.example.booknet.repository.library.BaseLibraryStatus
import com.example.booknet.ui.flow.start.StartViewModel
import com.example.booknet.utils.Loader
import com.example.booknet.utils.SingleLifeEvent

class LibraryViewModel : ViewModel() {

    fun getItemList() = LibraryDataSource.libraryBooks
    fun isListEmpty() = getItemList().value.isNullOrEmpty()
}