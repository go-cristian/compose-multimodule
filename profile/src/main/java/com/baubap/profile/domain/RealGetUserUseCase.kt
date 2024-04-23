package com.baubap.profile.domain

import com.baubap.common.repositories.SettingsRepository
import com.baubap.common.repositories.User
import javax.inject.Inject

class RealGetUserUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository,
) : GetUserUseCase {
    override suspend fun exec(): User {
        val user = settingsRepository.settings()?.user!!
        return user
    }
}