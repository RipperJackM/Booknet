package com.example.booknet.repository.book

import com.example.booknet.api.DataResult
import com.example.booknet.datastorage.user.UserDataStorage
import com.example.booknet.mappers.book.BookChapterMapper
import com.example.booknet.network.book.BookDataFetcher

class BookRepositoryImpl(
    private val fetcher: BookDataFetcher,
    private val bookChapterMapper: BookChapterMapper,
    private val dataStorage: UserDataStorage
) : BookRepository {
    override fun getBookChapters(
        bookId: String,
        completionHandler: GetBookChapterCallback
    ) {
        fetcher.getBookChapters(
            bookId,
            dataStorage.appName,
            dataStorage.deviceId,
            dataStorage.token,
            dataStorage.apiVersion,
            dataStorage.sign
        ) { result ->
            when (result) {
                is DataResult.Success -> completionHandler(
                    BookChapterStatus.Success(bookChapterMapper.mapToModel(result.data.result))
                )
                is DataResult.Failure -> completionHandler(BookChapterStatus.ApiError(result.errorModel))
                is DataResult.FailureHttp -> completionHandler(BookChapterStatus.HttpError(result.error))
            }
        }
    }
}