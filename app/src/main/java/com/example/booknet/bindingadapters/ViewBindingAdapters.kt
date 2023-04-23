package com.example.booknet.bindingadapters

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("isViewVisible")
fun View.isViewVisible(isVisible: Boolean) {
    this.isVisible = isVisible
}

@BindingAdapter("isViewGone")
fun View.isViewGone(isGone: Boolean) {
    this.isGone = isGone
}