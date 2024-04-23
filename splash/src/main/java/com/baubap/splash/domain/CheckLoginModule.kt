package com.baubap.splash.domain

import com.baubap.common.repositories.SettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class CheckLoginModule {
    @Provides
    fun providesCheckLoginUseCase(
        settingsRepository: SettingsRepository,
    ): CheckLoginUseCase =
        RealCheckLoginUseCase(
            settingsRepository = settingsRepository,
        )
}