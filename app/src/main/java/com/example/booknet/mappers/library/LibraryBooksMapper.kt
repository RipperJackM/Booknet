package com.example.booknet.mappers.library

import com.example.booknet.apimodels.response.library.LibraryBookDto
import com.example.booknet.models.library.LibraryBookModel
import com.example.booknet.utils.Mapper

class LibraryBooksMapper(
    private val genresMapper: LibraryBooksGenresMapper
) : Mapper<LibraryBookDto?, LibraryBookModel> {
    override fun mapToModel(entity: LibraryBookDto?) = LibraryBookModel(
        id = entity?.book?.id ?: -1,
        title = entity?.book?.title ?: "",
        authorName = entity?.book?.authorName ?: "",
        type = entity?.book?.type ?: "",
        genres = genresMapper.mapToModel(entity?.book?.genres ?: listOf()),
        annotation = entity?.book?.annotation ?: "",
        cover = entity?.book?.cover ?: "",
        intro = entity?.book?.intro ?: false,
        rating = entity?.book?.rating ?: -1,
        totalChrLength = entity?.book?.totalChrLength ?: -1,
        pages = entity?.book?.pages ?: -1,
        status = entity?.book?.status ?: "",
        lang = entity?.book?.lang ?: "",
        libraryType = entity?.libInfo?.type ?: -1
    )

    override fun mapToEntity(model: LibraryBookModel): LibraryBookDto? {
        // not needed now
        return null
    }
}