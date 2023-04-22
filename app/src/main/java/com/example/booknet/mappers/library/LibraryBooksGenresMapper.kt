package com.example.booknet.mappers.library

import com.example.booknet.apimodels.response.library.GenreDto
import com.example.booknet.models.library.GenresModel
import com.example.booknet.utils.Mapper

class LibraryBooksGenresMapper : Mapper<GenreDto?, GenresModel> {
    override fun mapToModel(entity: GenreDto?) = GenresModel(
        id = entity?.id ?: -1,
        name = entity?.name ?: "",
        ratingPlace = entity?.ratingPlace ?: -1
    )

    override fun mapToEntity(model: GenresModel): GenreDto? {
        // not needed now
        return null
    }
}