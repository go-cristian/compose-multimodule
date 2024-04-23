package com.baubap.app

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.retry
import java.io.IOException

fun List<Map<String, String>>.asComposeArguments(): List<String> {
    return this.map { argument ->
        argument.entries.first().value
    }
}

fun <T> Flow<T>.useCase(): Flow<T> = flowOn(Dispatchers.IO).retryIO()

fun <T> Flow<T>.retryIO(): Flow<T> {
    var delayTime = 500L
    val delayFactor = 300L
    return retry(retries = 3) { cause ->
        if (cause.isIOInValid()) {
            delay(delayTime)
            delayTime += delayFactor
            true
        } else {
            false
        }
    }
}

private fun Throwable.isIOInValid() = this is IOException || this is RuntimeException