package com.example.booknet.ui.flow.home.archive

import androidx.lifecycle.ViewModel
import com.example.booknet.datasource.library.LibraryDataSource

class ArchiveViewModel: ViewModel() {
    fun getItemList() = LibraryDataSource.archiveBooks
    fun isListEmpty() = getItemList().value.isNullOrEmpty()
}