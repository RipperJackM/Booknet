package com.example.booknet.ui.flow.read

import com.example.booknet.R
import com.example.booknet.ui.base.recycler.MultiValuesRecyclerViewData

class PageViewData(
    val text: String,
    pageNumber: Int,
    override val layoutId: Int = R.layout.item_page
) : MultiValuesRecyclerViewData() {
    val pageNumberText = "Сторінка $pageNumber"
    val isChapterGone = pageNumber > 1
}