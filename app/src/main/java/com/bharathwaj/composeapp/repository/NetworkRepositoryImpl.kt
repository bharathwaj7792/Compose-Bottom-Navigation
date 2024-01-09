package com.bharathwaj.composeapp.repository

import com.bharathwaj.composeapp.network.NetworkService
import com.bharathwaj.composeapp.data.PhotoResponse
import com.bharathwaj.composeapp.network.CuratedPhotoService
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
): NetworkRepository {

    private val curatedPhotoService = networkService.createApiService(CuratedPhotoService::class.java)

    override suspend fun getCuratedPhotos(page: Int, perPage: Int): PhotoResponse {
        return curatedPhotoService.getCuratedPhotos(page, perPage)
    }
}