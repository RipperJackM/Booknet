package com.example.booknet.models.library

import com.google.gson.annotations.SerializedName

data class LibraryBookModel(
    val id: Int,
    val title: String,
    @SerializedName("author_id") val authorId: Int,
    @SerializedName("author_name") val authorName: String,
    @SerializedName("author_avatar_url") val authorAvatarUrl: String,
    @SerializedName("co_author") val coAuthor: String,
    @SerializedName("co_author_name") val coAuthorName: String,
    @SerializedName("co_author_avatar_url") val coAuthorAvatarUrl: String,
    @SerializedName("pub_id") val pubId: String,
    @SerializedName("pub_name") val pubName: String,
    val type: String,
    val genres: List<GenresModel>,
    val annotation: String,
    val cover: String,
    @SerializedName("created_at") val createdAt: Int,
    @SerializedName("adult_only") val adultOnly: Boolean,
    @SerializedName("book_active") val bookActive: Boolean,
    val intro: Boolean,
    val rating: Int,
    val views: Int,
    @SerializedName("in_libraries") val inLibraries: Int,
    @SerializedName("text_to_speech_allowed") val textToSpeechAllowed: Boolean,
    @SerializedName("total_chr_length") val totalChrLength: Int,
    val pages: Int,
    val url: String,
    val status: String,
    val lang: String,
    @SerializedName("currency_code") val currencyCode: String,
    @SerializedName("author_books_count") val authorBooksCount: Int,
    @SerializedName("booktrailer") val booktrailer: String,
    val publisher: String,
    val hidden: String,
)

data class GenresModel(
    val id: Int,
    val name: String,
    @SerializedName("rating_place") val ratingPlace: Int
)