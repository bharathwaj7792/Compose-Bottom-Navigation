package com.bharathwaj.composeapp.repository

import com.bharathwaj.composeapp.data.PhotoResponse

interface NetworkRepository {
    suspend fun getCuratedPhotos(page: Int, perPage: Int): PhotoResponse
}