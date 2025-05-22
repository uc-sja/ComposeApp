package com.example.composeapp.data

import kotlinx.serialization.Serializable

@Serializable
data class Car(
    val side: String? = null,
    val signs: List<String>? = null
)