package com.baubap.dashboard.domain

import com.baubap.common.repositories.HttpClient
import com.baubap.common.repositories.SettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object GetAccountStateModule {
    @Provides
    fun providesGetAccountStateUseCase(
        settingsRepository: SettingsRepository,
        httpClient: HttpClient,
    ): GetAccountStateUseCase =
        RealGetAccountStateUseCase(
            settingsRepository = settingsRepository,
            httpClient = httpClient,
        )
}