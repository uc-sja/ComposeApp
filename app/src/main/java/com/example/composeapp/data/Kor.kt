package com.example.composeapp.data

import kotlinx.serialization.Serializable

@Serializable
data class Kor(
    val common: String? = null,
    val official: String? = null
)