package com.velev.outdoorsy.data

/**
 * @author Iliya Velev
 * @since 1.0
 */
sealed class ResultData<out R> {
    data class Success<out T>(val data: T?) : ResultData<T>()
    data class Error(val exception: Exception) : ResultData<Nothing>()
    object Loading : ResultData<Nothing>()
    object None : ResultData<Nothing>()
}