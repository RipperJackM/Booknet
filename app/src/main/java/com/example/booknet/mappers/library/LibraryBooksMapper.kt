package com.example.booknet.mappers.library

import com.example.booknet.apimodels.response.library.LibraryBookDto
import com.example.booknet.models.library.GenresModel
import com.example.booknet.models.library.LibraryBookModel
import com.example.booknet.utils.Mapper
import com.google.gson.annotations.SerializedName

class LibraryBooksMapper(
    private val genresMapper: LibraryBooksGenresMapper
) : Mapper<LibraryBookDto?, LibraryBookModel> {
    override fun mapToModel(entity: LibraryBookDto?) = LibraryBookModel(
        id = entity?.book?.id ?: -1,
        title = entity?.book?.title ?: "",
        authorId = entity?.book?.authorId ?: -1,
        authorName = entity?.book?.authorName ?: "",
        authorAvatarUrl = entity?.book?.authorAvatarUrl ?: "",
        coAuthor = entity?.book?.coAuthor ?: "",
        coAuthorName = entity?.book?.coAuthorName ?: "",
        coAuthorAvatarUrl = entity?.book?.coAuthorAvatarUrl ?: "",
        pubId = entity?.book?.pubId ?: "",
        pubName = entity?.book?.pubName ?: "",
        type = entity?.book?.type ?: "",
        genres = genresMapper.mapToModel(entity?.book?.genres ?: listOf()),
        annotation = entity?.book?.annotation ?: "",
        cover = entity?.book?.cover ?: "",
        createdAt = entity?.book?.createdAt ?: -1,
        adultOnly = entity?.book?.adultOnly ?: false,
        bookActive = entity?.book?.bookActive ?: false,
        intro = entity?.book?.intro ?: false,
        rating = entity?.book?.rating ?: -1,
        views = entity?.book?.views ?: -1,
        inLibraries = entity?.book?.inLibraries ?: -1,
        textToSpeechAllowed = entity?.book?.textToSpeechAllowed ?: false,
        totalChrLength = entity?.book?.totalChrLength ?: -1,
        pages = entity?.book?.pages ?: -1,
        url = entity?.book?.url ?: "",
        status = entity?.book?.status ?: "",
        lang = entity?.book?.lang ?: "",
        currencyCode = entity?.book?.currencyCode ?: "",
        authorBooksCount = entity?.book?.authorBooksCount ?: -1,
        booktrailer = entity?.book?.booktrailer ?: "",
        publisher = entity?.book?.publisher ?: "",
        hidden = entity?.book?.hidden ?: "",
    )

    override fun mapToEntity(model: LibraryBookModel): LibraryBookDto? {
        // not needed now
        return null
    }
}