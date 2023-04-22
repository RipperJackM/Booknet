package com.example.booknet.apimodels.response.library

import com.google.gson.annotations.SerializedName

data class LibraryBookDto(
    @SerializedName("lib_info")
    val libInfo: LibInfoDto,
    val book: LibraryBookDetailDto
)

data class LibraryBookDetailDto(
    val id: Long?,
    val title: String?,
    @SerializedName("author_id")
    val authorID: Long?,
    @SerializedName("author_name")
    val authorName: String?,
    @SerializedName("author_avatar_url")
    val authorAvatarURL: String?,
    @SerializedName("co_author")
    val coAuthor: Boolean?,
    @SerializedName("co_author_name")
    val coAuthorName: String?,
    @SerializedName("co_author_avatar_url")
    val coAuthorAvatarURL: String?,
    @SerializedName("pub_id")
    val pubID: Long?,
    @SerializedName("pub_name")
    val pubName: String?,
    val type: String?,
    @SerializedName("bonus_balance_promocode")
    val bonusBalancePromocode: Boolean?,
    val genres: List<GenreDto>?,
    val tags: List<TagDto>?,
    val annotation: String?,
    val cover: String?,
    @SerializedName("created_at")
    val createdAt: Long?,
    @SerializedName("finished_at")
    val finishedAt: Long?,
    @SerializedName("last_update")
    val lastUpdate: Long?,
    @SerializedName("adult_only")
    val adultOnly: Boolean?,
    @SerializedName("book_active")
    val bookActive: Boolean?,
    val intro: Boolean?,
    @SerializedName("free_chapters")
    val freeChapters: Long?,
    val rating: Long?,
    val likes: Long?,
    val rewards: Long?,
    val views: Long?,
    @SerializedName("in_libraries")
    val inLibraries: Long?,
    val comments: Long?,
    @SerializedName("allow_comments")
    val allowComments: Boolean?,
    @SerializedName("text_to_speech_allowed")
    val textToSpeechAllowed: Boolean?,
    @SerializedName("total_chr_length")
    val totalChrLength: Long?,
    val pages: Long?,
    val price: Double?,
    val blocked: Boolean?,
    val url: String?,
    val liked: Boolean?,
    val rewarded: Boolean?,
    val status: String?,
    @SerializedName("is_purchased")
    val isPurchased: Boolean?,
    val lang: String?,
    @SerializedName("currency_code")
    val currencyCode: String?,
    @SerializedName("author_books_count")
    val authorBooksCount: Long?,
    @SerializedName("co_author_books_count")
    val coAuthorBooksCount: Long?,
    @SerializedName("cycle_id")
    val cycleID: Long? = null,
    @SerializedName("priority_cycle")
    val priorityCycle: Long,
    val booktrailer: String,
    @SerializedName("tmp_access_sold")
    val tmpAccessSold: Any? = null,
    val publisher: Any? = null,
    @SerializedName("selling_frozen")
    val sellingFrozen: Boolean,
    val hidden: Boolean? = null,
    @SerializedName("has_audio")
    val hasAudio: Boolean? = null
)

data class GenreDto(
    val id: Long?,
    val name: String?,
    @SerializedName("rating_place")
    val ratingPlace: Long?
)

data class TagDto(
    val id: Long?,
    val name: String?
)

data class LibInfoDto(
    @SerializedName("add_date")
    val addDate: Long?,
    @SerializedName("last_chr_count")
    val lastChrCount: Long?,
    val type: Long?
)