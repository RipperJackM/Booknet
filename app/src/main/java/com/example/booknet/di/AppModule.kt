package com.example.booknet.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.booknet.App
import com.example.booknet.datastorage.AppConfig
import com.example.booknet.datastorage.user.UserDataStorage
import com.example.booknet.mappers.book.BookChapterMapper
import com.example.booknet.mappers.library.LibraryBooksGenresMapper
import com.example.booknet.mappers.library.LibraryBooksMapper
import com.example.booknet.network.ApiService
import com.example.booknet.network.book.BookDataFetcher
import com.example.booknet.network.library.LibraryDataFetcher
import com.example.booknet.repository.book.BookRepository
import com.example.booknet.repository.book.BookRepositoryImpl
import com.example.booknet.repository.library.LibraryRepository
import com.example.booknet.repository.library.LibraryRepositoryImpl
import com.example.booknet.ui.flow.home.archive.ArchiveViewModel
import com.example.booknet.ui.flow.home.favorites.FavouritesViewModel
import com.example.booknet.ui.flow.home.iread.IReadViewModel
import com.example.booknet.ui.flow.home.library.LibraryViewModel
import com.example.booknet.ui.flow.read.ReadViewModel
import com.example.booknet.ui.flow.start.StartViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.concurrent.TimeUnit


val applicationModule = module {

    // Core
    single { androidApplication() as App }
    single { AppConfig(androidContext()) }

    // Network
    single {
        Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader("Connection", "close")
            requestBuilder.addHeader("Authorization", "Basic bGl0ZGV2OlBUaThleTYydGp5MFVlNg==")
            try {
                chain.proceed(requestBuilder.build())
            } catch (e: Exception) {
                chain.proceed(requestBuilder.build())
            }
        }
    }

    single {
        OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(ChuckerInterceptor(androidContext()))
            .addInterceptor(get<Interceptor>())
            .retryOnConnectionFailure(false)
            .build()
    }

    single { ApiService(get()) }

    // Data fetchers
    single { LibraryDataFetcher(get()) }
    single { BookDataFetcher(get()) }

    // Data storages
    single { UserDataStorage(get()) }

    // Mappers
    single { LibraryBooksGenresMapper() }
    single { LibraryBooksMapper(get()) }
    single { BookChapterMapper() }

    // Repositories
    single<LibraryRepository> { LibraryRepositoryImpl(get(), get(), get()) }
    single<BookRepository> { BookRepositoryImpl(get(), get(), get()) }

    // View models
    viewModel { StartViewModel(get(), get()) }
    viewModel { LibraryViewModel() }
    viewModel { IReadViewModel() }
    viewModel { FavouritesViewModel() }
    viewModel { ArchiveViewModel() }
    viewModel { ReadViewModel(get()) }
}