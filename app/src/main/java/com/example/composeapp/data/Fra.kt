package com.example.composeapp.data

import kotlinx.serialization.Serializable

@Serializable
data class Fra(
    val common: String? = null,
    val official: String? = null
)