package com.bharathwaj.composeapp.data

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class PhotoResponse(
    val page: Int,
    val perPage: Int,
    val photos: List<Photo>,
    val nextPage: String?
)
