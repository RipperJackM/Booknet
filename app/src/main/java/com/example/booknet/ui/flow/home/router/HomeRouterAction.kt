package com.example.booknet.ui.flow.home.router

import com.example.booknet.models.library.LibraryBookModel

sealed class HomeRouterAction {
    data class ShowReadFragment(val book: LibraryBookModel) : HomeRouterAction()
}