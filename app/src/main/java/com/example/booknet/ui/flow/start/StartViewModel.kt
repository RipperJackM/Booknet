package com.example.booknet.ui.flow.start

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.booknet.datasource.library.LibraryDataSource
import com.example.booknet.datastorage.user.UserDataStorage
import com.example.booknet.repository.library.BaseLibraryStatus
import com.example.booknet.repository.library.LibraryRepository
import com.example.booknet.utils.SingleLifeEvent

class StartViewModel(
    private val repository: LibraryRepository,
    private val dataStorage: UserDataStorage,
) : ViewModel() {

    private val _uiState = SingleLifeEvent<UiState>()
    val uiState: LiveData<UiState> = _uiState

    sealed class UiState {
        object OnGetUserCredentials : UiState()
        object OnGetLibraryData : UiState()
        data class Failure(val error: String) : UiState()
    }

    fun isUserAuthorized() = dataStorage.isUserLogged

    @SuppressLint("HardwareIds")
    fun getUserCredentials(context: Context) {
        dataStorage.appName = "android_booknet"
        dataStorage.deviceId = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        dataStorage.token = "dtknyWZS7VmiR_mV3DLYRIPYdej8L9ps"
        dataStorage.apiVersion = "50"
        dataStorage.isUserLogged = true
        _uiState.postValue(UiState.OnGetUserCredentials)
    }

    fun getLibraryData() {
        repository.getLibraryBooks { result ->
            val state = when (result) {
                is BaseLibraryStatus.Success -> {
                    LibraryDataSource.libraryBooks.postValue(result.libraryBooksList)
                    UiState.OnGetLibraryData
                }
                is BaseLibraryStatus.HttpError -> UiState.Failure(result.error)
                is BaseLibraryStatus.ApiError -> UiState.Failure(result.errorModel.message)
            }
            _uiState.postValue(state)
        }
    }
}