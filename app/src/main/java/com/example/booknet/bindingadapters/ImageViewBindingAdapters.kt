package com.example.booknet.bindingadapters

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun AppCompatImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}