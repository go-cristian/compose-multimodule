package com.baubap.dashboard.domain

import com.baubap.common.Response
import com.baubap.common.repositories.User

data class AccountData(
    val user: User,
    val totalDebt: String,
    val creditTotal: String,
    val date: String,
    val loanNumber: String,
    val loanTime: String,
) {
    companion object {
        val Example = AccountData(
            user = User.Example,
            totalDebt = "$645.00",
            creditTotal = "$500.00",
            date = "14 Nov 2022",
            loanNumber = "0004382671",
            loanTime = "16 dias",
        )
    }
}

interface GetAccountStateUseCase {
    suspend fun exec(): Response<AccountData>
}