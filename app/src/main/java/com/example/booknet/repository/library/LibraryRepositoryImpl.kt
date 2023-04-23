package com.example.booknet.repository.library

import com.example.booknet.api.DataResult
import com.example.booknet.datastorage.user.UserDataStorage
import com.example.booknet.mappers.library.LibraryBooksMapper
import com.example.booknet.network.library.LibraryDataFetcher

class LibraryRepositoryImpl(
    private val fetcher: LibraryDataFetcher,
    private val libraryMapper: LibraryBooksMapper,
    private val dataStorage: UserDataStorage
) : LibraryRepository {

    override fun getLibraryBooks(completionHandler: GetLibraryBooksCallback) {
        fetcher.getBooks(
            dataStorage.appName,
            dataStorage.deviceId,
            dataStorage.token,
            dataStorage.apiVersion,
            dataStorage.sign
        ) { result ->
            when (result) {
                is DataResult.Success -> completionHandler(
                    BaseLibraryStatus.Success(libraryMapper.mapToModel(result.data.result))
                )
                is DataResult.Failure -> completionHandler(BaseLibraryStatus.ApiError(result.errorModel))
                is DataResult.FailureHttp -> completionHandler(BaseLibraryStatus.HttpError(result.error))
            }
        }
    }
}