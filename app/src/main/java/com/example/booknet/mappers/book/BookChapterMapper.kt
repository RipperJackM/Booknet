package com.example.booknet.mappers.book

import com.example.booknet.apimodels.response.book.BookChapterDto
import com.example.booknet.models.book.BookChapterModel
import com.example.booknet.utils.Mapper

class BookChapterMapper : Mapper<BookChapterDto?, BookChapterModel> {
    override fun mapToModel(entity: BookChapterDto?) = BookChapterModel(
        id = entity?.id ?: -1,
        access = entity?.access ?: false,
        text = entity?.text
    )

    override fun mapToEntity(model: BookChapterModel): BookChapterDto? {
        // not needed now
        return null
    }
}