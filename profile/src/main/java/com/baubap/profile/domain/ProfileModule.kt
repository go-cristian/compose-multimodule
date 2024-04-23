package com.baubap.profile.domain

import com.baubap.common.repositories.HttpClient
import com.baubap.common.repositories.SettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ProfileModule {
    @Provides
    fun providesGetUserUseCase(
        settingsRepository: SettingsRepository,
    ): GetUserUseCase =
        RealGetUserUseCase(
            settingsRepository = settingsRepository,
        )

    @Provides
    fun providesLogoutUseCase(
        settingsRepository: SettingsRepository,
        httpClient: HttpClient,
    ): LogoutUseCase =
        RealLogoutUseCase(
            settingsRepository = settingsRepository,
            httpClient = httpClient,
        )
}