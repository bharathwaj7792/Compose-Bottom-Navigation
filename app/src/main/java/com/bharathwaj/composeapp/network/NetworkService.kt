package com.bharathwaj.composeapp.network

import retrofit2.Retrofit
import javax.inject.Inject

class NetworkService @Inject constructor(
    private val retrofit: Retrofit
){
    fun <T> createApiService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}