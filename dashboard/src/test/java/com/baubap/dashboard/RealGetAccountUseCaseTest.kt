package com.baubap.dashboard

import androidx.test.platform.app.InstrumentationRegistry
import com.baubap.common.Response
import com.baubap.common.asSuccess
import com.baubap.common.dataStore
import com.baubap.common.repositories.HttpClient
import com.baubap.common.repositories.Settings
import com.baubap.common.repositories.SettingsRepository
import com.baubap.common.repositories.User
import com.baubap.dashboard.domain.AccountData
import com.baubap.dashboard.domain.RealGetAccountStateUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = ShadowTestApp::class, packageName = "com.baubap")
class RealGetAccountUseCaseTest {

    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val dataStore = context.dataStore
    private val settingsRepository = SettingsRepository(dataStore)

    @Test
    fun `gets account state`() = runTest {
        settingsRepository.save(Settings(accessToken = "", user = User.Example))
        val useCase = RealGetAccountStateUseCase(
            settingsRepository = settingsRepository,
            httpClient = HttpClient.Fake(),
        )
        val response = useCase.exec()
        Assert.assertEquals(AccountData.Example.asSuccess(), response)
        settingsRepository.clear()
    }

    @Test
    fun `fails with no user in settings`() = runTest {
        val useCase = RealGetAccountStateUseCase(
            settingsRepository = settingsRepository,
            httpClient = HttpClient.Fake(),
        )
        val response = useCase.exec()
        Assert.assertEquals(
            "Error getting account state",
            (response as Response.Failure).error?.message,
        )
        settingsRepository.clear()
    }
}