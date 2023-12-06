package com.bharathwaj.composeapp.network

import com.bharathwaj.composeapp.data.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CuratedPhotoService {
    @GET("/v1/curated/")
    suspend fun getCuratedPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): PhotoResponse
}