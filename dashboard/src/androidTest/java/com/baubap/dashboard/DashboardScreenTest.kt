package com.baubap.dashboard

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.baubap.common.Response
import com.baubap.common.asSuccess
import com.baubap.dashboard.domain.AccountData
import com.baubap.dashboard.domain.GetAccountStateUseCase
import com.baubap.dashboard.ui.Tags
import com.baubap.ds.ui.theme.AppTheme
import kotlinx.coroutines.delay
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DashboardScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun showsSuccessScreen() {
        composeTestRule.setContent {
            AppTheme(useDarkTheme = false) {
                DashboardScreen(
                    DashboardViewModel(
                        object : GetAccountStateUseCase {
                            override suspend fun exec(): Response<AccountData> =
                                AccountData.Example.asSuccess()
                        }
                    )
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")

        composeTestRule
            .onNodeWithTag(Tags.Welcome)
            .assertTextContains("Bienvenido John Doe")
        composeTestRule
            .onNodeWithTag(Tags.ToPay)
            .assertTextContains("$645.00")
        composeTestRule
            .onNodeWithTag(Tags.TotalDebt)
            .assertTextContains("$500.00")
        composeTestRule
            .onNodeWithTag(Tags.PayDate)
            .assertTextContains("14 Nov 2022")
        composeTestRule
            .onNodeWithTag(Tags.LoanNumber)
            .assertTextContains("0004382671")
        composeTestRule
            .onNodeWithTag(Tags.LoanTime)
            .assertTextContains("16 dias")
    }

    @Test
    fun showsLoadingScreen() {
        composeTestRule.setContent {
            AppTheme(useDarkTheme = false) {
                DashboardScreen(
                    DashboardViewModel(
                        object : GetAccountStateUseCase {
                            override suspend fun exec(): Response<AccountData> {
                                // Include a long delay to allow show the loading screen
                                delay(2000)
                                return AccountData.Example.asSuccess()
                            }

                        }
                    )
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")

        composeTestRule
            .onNodeWithTag("LoadingDashboardView")
            .assertExists()
    }

    @Test
    fun showsErrorScreen() {
        composeTestRule.setContent {
            AppTheme(useDarkTheme = false) {
                DashboardScreen(
                    DashboardViewModel(
                        object : GetAccountStateUseCase {
                            override suspend fun exec(): Response<AccountData> =
                                Response.Failure(Exception())
                        }
                    )
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")

        composeTestRule
            .onNodeWithTag("ErrorView")
            .assertExists()
    }
}