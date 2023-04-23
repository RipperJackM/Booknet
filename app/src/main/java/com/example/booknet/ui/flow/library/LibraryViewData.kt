package com.example.booknet.ui.flow.library

import com.example.booknet.R
import com.example.booknet.models.library.LibraryBookModel
import com.example.booknet.ui.base.recycler.MultiValuesRecyclerViewData

class LibraryItemViewData(
    val item: LibraryBookModel,
    override val layoutId: Int = R.layout.item_library_book
) : MultiValuesRecyclerViewData() {

    val genres = item.genres.joinToString(", ") { it.name }
}