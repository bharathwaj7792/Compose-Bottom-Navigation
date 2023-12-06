package com.bharathwaj.composeapp.data

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Photo(
    val id: Long,
    val width: Long,
    val height: Long,
    val url: String,
    val photographer: String,
    val photographerUrl: String,
    val photographerId: Long,
    val avgColor: String,
    val src: Src,
    val liked: Boolean,
    val alt: String,
)
