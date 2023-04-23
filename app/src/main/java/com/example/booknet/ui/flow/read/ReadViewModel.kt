package com.example.booknet.ui.flow.read

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.booknet.repository.book.BookChapterStatus
import com.example.booknet.repository.book.BookRepository
import com.example.booknet.utils.Loader
import com.example.booknet.utils.SingleLifeEvent

class ReadViewModel(
    private val repository: BookRepository
) : ViewModel() {

    val pages = MutableLiveData<List<String>>()

    private val _uiState = SingleLifeEvent<UiState>()
    val uiState: LiveData<UiState> = _uiState

    sealed class UiState {
        data class Failure(val error: String) : UiState()
    }

    fun getBookChapters(bookId: String) {
        Loader.isLoading(true)
        repository.getBookChapters(bookId) { result ->
            when (result) {
                is BookChapterStatus.Success -> pages.postValue(result.chapters.first().textPerPage)
                is BookChapterStatus.HttpError -> _uiState.postValue(UiState.Failure(result.error))
                is BookChapterStatus.ApiError -> _uiState.postValue(UiState.Failure(result.errorModel.message))
            }
            Loader.isLoading(false)
        }
    }
}