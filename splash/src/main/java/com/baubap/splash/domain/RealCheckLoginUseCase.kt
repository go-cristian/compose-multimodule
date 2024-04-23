package com.baubap.splash.domain

import com.baubap.common.repositories.SettingsRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class RealCheckLoginUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository,
) : CheckLoginUseCase {
    override suspend fun exec(): Boolean {
        delay(3000)
        val settings = settingsRepository.settings()
        return settings != null
    }
}