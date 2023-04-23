package com.example.booknet.models.library

import com.google.gson.annotations.SerializedName

data class LibraryBookModel(
    val id: Long,
    val title: String,
    val authorName: String,
    val type: String,
    val genres: List<GenresModel>,
    val annotation: String,
    val cover: String,
    val intro: Boolean,
    val rating: Long,
    val totalChrLength: Long,
    val pages: Long,
    val status: String,
    val lang: String,
    val libraryType: Int
)

data class GenresModel(
    val id: Long,
    val name: String,
    val ratingPlace: Long
)