package com.example.autodigamecorner.model

data class ApiResponseWrapper<T>(
    val message: String,
    val data: T
)
