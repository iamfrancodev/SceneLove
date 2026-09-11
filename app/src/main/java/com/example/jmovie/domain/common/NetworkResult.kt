package com.example.jmovie.domain.common

sealed interface NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>
    data class Error(val message: String, val throwable: Throwable? = null) : NetworkResult<Nothing>
}

