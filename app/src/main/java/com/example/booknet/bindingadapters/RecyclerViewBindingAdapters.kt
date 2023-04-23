package com.example.booknet.bindingadapters

import androidx.databinding.BindingAdapter
import com.example.booknet.models.library.LibraryBookModel
import com.example.booknet.ui.custome.book.BookRecyclerView
import com.example.booknet.ui.custome.library.LibraryRecyclerView

@BindingAdapter("setLibraryRecyclerItems")
fun LibraryRecyclerView.setLibraryRecyclerItems(list: List<LibraryBookModel>?) {
    this.updateData(list)
}

@BindingAdapter("setBookRecyclerItems")
fun BookRecyclerView.setBookRecyclerItems(list: List<String>?) {
    this.updateData(list)
}