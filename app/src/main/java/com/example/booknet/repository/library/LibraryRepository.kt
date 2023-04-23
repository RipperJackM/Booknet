package com.example.booknet.repository.library

typealias EmptyLibraryCallback = (status: EmptyLibraryStatus) -> Unit
typealias GetLibraryBooksCallback = (status: BaseLibraryStatus) -> Unit

interface LibraryRepository {
    fun getLibraryBooks(completionHandler: GetLibraryBooksCallback)
}