package com.example.booknet.mappers.library

import com.example.booknet.apimodels.response.library.GenresDto
import com.example.booknet.models.library.GenresModel
import com.example.booknet.utils.Mapper

class LibraryBooksGenresMapper : Mapper<GenresDto?, GenresModel> {
    override fun mapToModel(entity: GenresDto?) = GenresModel(
        id = entity?.id ?: -1,
        name = entity?.name ?: "",
        ratingPlace = entity?.ratingPlace ?: -1
    )

    override fun mapToEntity(model: GenresModel): GenresDto? {
        // not needed now
        return null
    }
}