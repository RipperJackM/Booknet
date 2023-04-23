package com.example.booknet.ui.flow.home.favorites

import androidx.lifecycle.ViewModel
import com.example.booknet.datasource.library.LibraryDataSource

class FavouritesViewModel: ViewModel() {
    fun getItemList() = LibraryDataSource.favouriteBooks
    fun isListEmpty() = getItemList().value.isNullOrEmpty()
}