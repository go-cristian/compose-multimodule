package com.baubap.profile.domain

import com.baubap.common.Response
import com.baubap.common.repositories.HttpClient
import com.baubap.common.repositories.SettingsRepository
import javax.inject.Inject

class RealLogoutUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val httpClient: HttpClient,
) : LogoutUseCase {
    override suspend fun exec(): Response<Boolean> {
        settingsRepository.clear()
        httpClient.post("/logout")
        return Response.Success(true)
    }
}