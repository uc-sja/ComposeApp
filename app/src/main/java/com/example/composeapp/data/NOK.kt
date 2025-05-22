package com.example.composeapp.data

import kotlinx.serialization.Serializable

@Serializable
data class NOK(
    val name: String? = null,
    val symbol: String? = null
)