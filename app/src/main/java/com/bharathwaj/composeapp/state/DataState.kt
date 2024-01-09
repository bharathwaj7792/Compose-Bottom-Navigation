package com.bharathwaj.composeapp.state

sealed class DataState<out T> {
    object Loading : DataState<Nothing>()
    data class Success<T>(val data: T) : DataState<T>()
    data class Failure(val error: Throwable) : DataState<Nothing>()
}