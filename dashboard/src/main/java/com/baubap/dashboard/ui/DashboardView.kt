package com.baubap.dashboard.ui

import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baubap.common.UnitFunction
import com.baubap.common.repositories.User
import com.baubap.dashboard.R
import com.baubap.dashboard.domain.AccountData
import com.baubap.ds.components.Body1
import com.baubap.ds.components.Body4Bold
import com.baubap.ds.components.Body4Medium
import com.baubap.ds.components.LargeTitle
import com.baubap.ds.components.PrimaryButton
import com.baubap.ds.components.Title
import com.baubap.ds.ui.theme.AppTheme
import com.baubap.ds.ui.theme.Black
import com.baubap.ds.ui.theme.LightPurple
import com.baubap.ds.ui.theme.Violet
import com.baubap.ds.ui.theme.White
import com.baubap.ds.ui.theme.orInDarkTheme

object Colors {
    val title
        @Composable get() = White orInDarkTheme Black
}

object Tags {
    const val Welcome = "Welcome"
    const val ToPay = "ToPay"
    const val TotalDebt = "TotalDebt"
    const val PayDate = "PayDate"
    const val LoanNumber = "LoanNumber"
    const val LoanTime = "LoanTime"
}


@Composable
fun DashboardView(
    accountData: AccountData,
    modifier: Modifier = Modifier,
    onPaymentClick: UnitFunction = {},
) {
    val scrollState = rememberScrollState()
    Surface {
        Column(
            modifier = modifier
                .scrollable(scrollState, Orientation.Vertical)
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(84.dp)
                    .padding(end = 50.dp, top = 24.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomEnd = 30.dp,
                            topEnd = 30.dp,
                        )
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Title(
                    text = stringResource(id = R.string.welcome, accountData.user.name),
                    color = Colors.title,
                    textAlign = TextAlign.Center,
                    testTag = Tags.Welcome,
                    modifier = Modifier
                        .background(Violet)
                        .fillMaxSize(),
                )
            }
            Spacer(modifier = Modifier.size(24.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Body1(
                        text = stringResource(id = R.string.to_pay),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.size(24.dp))
                    LargeTitle(
                        text = accountData.totalDebt,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        testTag = Tags.ToPay,
                    )
                    Spacer(modifier = Modifier.size(24.dp))
                    Body4Bold(
                        text = stringResource(id = R.string.to_pay),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    Body4Medium(
                        text = accountData.creditTotal,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                        testTag = Tags.TotalDebt,
                    )
                    Spacer(modifier = Modifier.size(24.dp))
                    Body4Bold(
                        text = stringResource(id = R.string.payment_date),
                        leadingIcon = Icons.Outlined.CalendarMonth,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = LightPurple,
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    Body1(
                        text = accountData.date,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                        testTag = Tags.PayDate,
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            Body1(
                text = stringResource(id = R.string.loan_info),
                textAlign = TextAlign.Center,
                color = LightPurple,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.size(24.dp))
            Divider()
            Spacer(modifier = Modifier.size(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            ) {
                Body1(text = stringResource(id = R.string.loan_number))
                Spacer(modifier = Modifier.weight(1f))
                Body1(
                    text = accountData.loanNumber,
                    modifier = Modifier,
                    testTag = Tags.LoanNumber,
                )
            }
            Spacer(modifier = Modifier.size(24.dp))
            Divider()
            Spacer(modifier = Modifier.size(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            ) {
                Body1(text = stringResource(id = R.string.payment_time))
                Spacer(modifier = Modifier.weight(1f))
                Body1(
                    text = accountData.loanTime,
                    modifier = Modifier,
                    testTag = Tags.LoanTime,
                )
            }
            Spacer(modifier = Modifier.size(24.dp))
            Divider()
            Spacer(modifier = Modifier.size(24.dp))
            PrimaryButton(
                text = stringResource(id = R.string.make_payment),
                onClick = onPaymentClick,
                modifier = Modifier.padding(horizontal = 24.dp),
            )
        }
    }
}


@Composable
@Preview(uiMode = UI_MODE_TYPE_NORMAL)
fun LoginViewPreview() {
    val context = LocalContext.current
    CompositionLocalProvider(LocalContext provides context) {
        AppTheme(useDarkTheme = false) {
            DashboardView(
                accountData = AccountData(
                    user = User(
                        id = "1", name = "Luis", email = "", username = ""
                    ),
                    totalDebt = "$645.00",
                    creditTotal = "$500.00",
                    date = "14 Nov 2022",
                    loanNumber = "0004382671",
                    loanTime = "16 dias",
                )
            )
        }
    }
}
