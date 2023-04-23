package com.example.booknet.ui.flow.home

import com.example.booknet.R
import com.example.booknet.models.library.LibraryBookModel
import com.example.booknet.ui.base.recycler.MultiValuesRecyclerViewData
import com.example.booknet.ui.flow.home.router.HomeRouter
import com.example.booknet.ui.flow.home.router.HomeRouterAction

class LibraryItemViewData(
    val item: LibraryBookModel,
    override val layoutId: Int = R.layout.item_library_book
) : MultiValuesRecyclerViewData() {

    val genres = item.genres.joinToString(", ") { it.name }

    fun onClick() {
        HomeRouter.navigate(HomeRouterAction.ShowReadFragment(item))
    }
}