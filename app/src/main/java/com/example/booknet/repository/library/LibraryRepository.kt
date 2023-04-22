package com.example.booknet.repository.library

interface LibraryRepository {
    fun getLibraryBooks(completionHandler: GetLibraryBooksCallback)
}