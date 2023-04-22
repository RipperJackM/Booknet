package com.example.booknet.apimodels.response.library

import com.google.gson.annotations.SerializedName

data class LibraryBookDto(
    @SerializedName("lib_info") val libInfo: LibInfo?,
    val book: LibraryBookDetailDto?
)

data class LibraryBookDetailDto(
    val id: Int?,
    val title: String?,
    @SerializedName("author_id") val authorId: Int?,
    @SerializedName("author_name") val authorName: String?,
    @SerializedName("author_avatar_url") val authorAvatarUrl: String?,
    @SerializedName("co_author") val coAuthor: String?,
    @SerializedName("co_author_name") val coAuthorName: String?,
    @SerializedName("co_author_avatar_url") val coAuthorAvatarUrl: String?,
    @SerializedName("pub_id") val pubId: String?,
    @SerializedName("pub_name") val pubName: String?,
    val type: String?,
    @SerializedName("bonus_balance_promocode") var bonusBalancePromoCode: Boolean?,
    val genres: List<GenresDto>?,
    val tags: List<TagsDto>?,
    val annotation: String?,
    val cover: String?,
    @SerializedName("created_at") val createdAt: Int?,
    @SerializedName("finished_at") val finishedAt: Int?,
    @SerializedName("last_update") val lastUpdate: Int?,
    @SerializedName("adult_only") val adultOnly: Boolean?,
    @SerializedName("book_active") val bookActive: Boolean?,
    val intro: Boolean?,
    @SerializedName("free_chapters") val freeChapters: Int?,
    val rating: Int?,
    val likes: Int?,
    val rewards: Int?,
    val views: Int?,
    @SerializedName("in_libraries") val inLibraries: Int?,
    val comments: Int?,
    @SerializedName("allow_comments") val allowComments: Boolean?,
    @SerializedName("text_to_speech_allowed") val textToSpeechAllowed: Boolean?,
    @SerializedName("total_chr_length") val totalChrLength: Int?,
    val pages: Int?,
    val price: Int?,
    val blocked: Boolean?,
    val url: String?,
    val liked: Boolean?,
    val rewarded: Boolean?,
    val status: String?,
    @SerializedName("is_purchased") val isPurchased: Boolean?,
    val lang: String?,
    @SerializedName("currency_code") val currencyCode: String?,
    @SerializedName("author_books_count") val authorBooksCount: Int?,
    @SerializedName("co_author_books_count") val coAuthorBooksCount: Int?,
    @SerializedName("cycle_id") val cycleId: String?,
    @SerializedName("priority_cycle") val priorityCycle: Int?,
    @SerializedName("booktrailer") val booktrailer: String?,
    @SerializedName("tmp_access_sold") val tmpAccessSold: String?,
    val publisher: String?,
    @SerializedName("selling_frozen") val sellingFrozen: Boolean?,
    val hidden: String?,
    @SerializedName("has_audio") val hasAudio: String?
)

data class TagsDto(
    val id: Int?,
    val name: String?
)

data class GenresDto(
    val id: Int?,
    val name: String?,
    @SerializedName("rating_place") val ratingPlace: Int?
)

data class LibInfo(
    @SerializedName("add_date") val addDate: Int?,
    @SerializedName("last_chr_count") val lastChrCount: Int?,
    val type: Int?
)