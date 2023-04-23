package com.example.booknet.ui.custome.library

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.example.booknet.models.library.LibraryBookModel
import com.example.booknet.ui.base.recycler.BookMultiValuesRecyclerAdapter
import com.example.booknet.ui.flow.home.LibraryItemViewData

class LibraryRecyclerView(context: Context, attributeSet: AttributeSet) : RecyclerView(context, attributeSet) {

    private val customAdapter: BookMultiValuesRecyclerAdapter = BookMultiValuesRecyclerAdapter(listOf())

    init {
        this.adapter = customAdapter
    }

    fun updateData(items: List<LibraryBookModel>?) {
        customAdapter.updateList(items?.map { LibraryItemViewData(it) } ?: listOf())
    }
}