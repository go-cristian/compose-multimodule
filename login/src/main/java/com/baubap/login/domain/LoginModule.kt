package com.baubap.login.domain

import com.baubap.common.repositories.HttpClient
import com.baubap.common.repositories.SettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object LoginModule {
    @Provides
    fun providesLoginUseCase(
        settingsRepository: SettingsRepository,
        httpClient: HttpClient,
    ): LoginUseCase =
        RealLoginUseCase(
            settingsRepository = settingsRepository,
            httpClient = httpClient,
        )
}