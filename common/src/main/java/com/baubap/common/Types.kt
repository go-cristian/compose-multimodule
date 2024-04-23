package com.baubap.common

import androidx.compose.runtime.Composable

typealias Component = @Composable () -> Unit
typealias TComponent<T> = @Composable (T) -> Unit
typealias UnitFunction = () -> Unit

sealed class Response<out T : Any?> {
    data class Success<out T : Any?>(val data: T) : Response<T>()
    data class Failure(val error: Throwable?) : Response<Nothing>()
}

fun <T : Any> T.asSuccess(): Response.Success<T> = Response.Success(this)
fun String.asFailure(): Response.Failure = Response.Failure(Exception(this))