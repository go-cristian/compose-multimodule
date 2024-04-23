package com.baubap.login.domain

import com.baubap.common.Response
import com.baubap.common.repositories.HttpClient
import com.baubap.common.repositories.Settings
import com.baubap.common.repositories.SettingsRepository
import com.baubap.common.repositories.User
import kotlinx.coroutines.delay
import javax.inject.Inject

class RealLoginUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val httpClient: HttpClient
) : LoginUseCase {
    override suspend fun login(email: String, password: String): Response<User> {
        httpClient.get("/login", mapOf("email" to email, "password" to password))
        val user = User.Example
        settingsRepository.save(
            Settings(
                accessToken = "token",
                user = user
            )
        )
        delay(3000)
        return Response.Success(user)
    }
}