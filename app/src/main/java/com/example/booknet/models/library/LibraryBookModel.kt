package com.example.booknet.models.library

import com.google.gson.annotations.SerializedName

data class LibraryBookModel(
    val id: Long,
    val title: String,
    val authorId: Long,
    val authorName: String,
    val authorAvatarUrl: String,
    val coAuthor: Boolean,
    val coAuthorName: String,
    val coAuthorAvatarUrl: String,
    val pubId: Long,
    val pubName: String,
    val type: String,
    val genres: List<GenresModel>,
    val annotation: String,
    val cover: String,
    val createdAt: Long,
    val adultOnly: Boolean,
    val bookActive: Boolean,
    val intro: Boolean,
    val rating: Long,
    val views: Long,
    val inLibraries: Long,
    val textToSpeechAllowed: Boolean,
    val totalChrLength: Long,
    val pages: Long,
    val url: String,
    val status: String,
    val lang: String,
    val currencyCode: String,
    val authorBooksCount: Long,
    val booktrailer: String,
    val publisher: Any,
    val hidden: Any,
)

data class GenresModel(
    val id: Long,
    val name: String,
    val ratingPlace: Long
)