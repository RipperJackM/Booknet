package com.example.booknet.ui.custome.book

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.booknet.ui.base.recycler.BookMultiValuesRecyclerAdapter
import com.example.booknet.ui.flow.read.PageViewData

class BookRecyclerView(context: Context, attributeSet: AttributeSet) : RecyclerView(context, attributeSet) {

    private val customAdapter: BookMultiValuesRecyclerAdapter = BookMultiValuesRecyclerAdapter(listOf())

    init {
        this.adapter = customAdapter
        PagerSnapHelper().attachToRecyclerView(this)
    }

    fun updateData(items: List<String>?) {
        customAdapter.updateList(items?.map {
            val position = items.indexOf(it)
            PageViewData(it, position + 1)
        } ?: listOf())
    }
}