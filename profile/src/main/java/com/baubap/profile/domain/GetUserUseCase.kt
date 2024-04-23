package com.baubap.profile.domain

import com.baubap.common.repositories.User

interface GetUserUseCase {
    suspend fun exec(): User
}