package com.baubap.login.domain

import com.baubap.common.Response
import com.baubap.common.repositories.User

interface LoginUseCase {
    suspend fun login(email: String, password: String): Response<User>
}