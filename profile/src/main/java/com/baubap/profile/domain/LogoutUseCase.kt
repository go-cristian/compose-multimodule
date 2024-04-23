package com.baubap.profile.domain

import com.baubap.common.Response

interface LogoutUseCase {
    suspend fun exec(): Response<Boolean>
}