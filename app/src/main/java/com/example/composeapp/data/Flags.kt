package com.example.composeapp.data

import kotlinx.serialization.Serializable

@Serializable
data class Flags(
    val png: String? = null,
    val svg: String? = null
)