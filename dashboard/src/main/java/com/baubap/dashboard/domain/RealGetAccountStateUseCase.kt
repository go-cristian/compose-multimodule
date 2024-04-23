package com.baubap.dashboard.domain

import com.baubap.common.Response
import com.baubap.common.repositories.HttpClient
import com.baubap.common.repositories.SettingsRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class RealGetAccountStateUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val httpClient: HttpClient
) : GetAccountStateUseCase {
    override suspend fun exec(): Response<AccountData> {
        try {
            httpClient.get("/account")
            val user = settingsRepository.settings()?.user!!
            val accountData = AccountData(
                user = user,
                totalDebt = "$645.00",
                creditTotal = "$500.00",
                date = "14 Nov 2022",
                loanNumber = "0004382671",
                loanTime = "16 dias",
            )
            delay(1000)
            return Response.Success(accountData)
        } catch (e: Exception) {
            return Response.Failure(Exception("Error getting account state"))
        }
    }
}