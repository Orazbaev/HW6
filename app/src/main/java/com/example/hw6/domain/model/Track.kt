package com.example.hw6.domain.model

data class Track(
    val id: Int,
    val title: String,
    val genre: String,
    val duration: Double, // минуты
    val imageResId: Int
)
