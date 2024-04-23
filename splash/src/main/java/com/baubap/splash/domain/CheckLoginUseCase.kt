package com.baubap.splash.domain

interface CheckLoginUseCase {
    suspend fun exec(): Boolean
}