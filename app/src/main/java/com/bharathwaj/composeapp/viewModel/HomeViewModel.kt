package com.bharathwaj.composeapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bharathwaj.composeapp.data.PhotoResponse
import com.bharathwaj.composeapp.repository.NetworkRepository
import com.bharathwaj.composeapp.state.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
): ViewModel() {

    private val _photoResponseData = MutableStateFlow<DataState<PhotoResponse>>(DataState.Loading)
    val photoResponseData: StateFlow<DataState<PhotoResponse>> = _photoResponseData

    fun getPhotoFeed() {
        viewModelScope.launch {
            try {
                val result = networkRepository.getCuratedPhotos(1, 10)
                _photoResponseData.value = DataState.Success(result)
            } catch (e: Exception) {
                _photoResponseData.value = DataState.Failure(e)
            }
        }
    }
}