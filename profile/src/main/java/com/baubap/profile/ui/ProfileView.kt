package com.baubap.profile.ui

import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baubap.common.UnitFunction
import com.baubap.common.repositories.User
import com.baubap.ds.components.Body1
import com.baubap.ds.components.LargeTitle
import com.baubap.ds.components.PrimaryButton
import com.baubap.ds.components.Title
import com.baubap.ds.ui.theme.AppTheme
import com.baubap.ds.ui.theme.LightPurple
import com.baubap.ds.ui.theme.White
import com.baubap.profile.R

@Composable
fun ProfileView(
    user: User,
    modifier: Modifier = Modifier,
    onLogout: UnitFunction = {},
) {
    Surface {
        Column(
            modifier = modifier.fillMaxSize(),
        ) {

            Spacer(modifier = Modifier.size(24.dp))

            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(100.dp)
                        .background(LightPurple, shape = CircleShape),
                ) {
                    Title(text = user.initials, color = White)
                }
                LargeTitle(
                    text = user.username,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
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
                Body1(text = stringResource(id = R.string.name))
                Spacer(modifier = Modifier.weight(1f))
                Body1(text = user.name)
            }
            Spacer(modifier = Modifier.size(24.dp))
            Divider()
            Spacer(modifier = Modifier.size(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            ) {
                Body1(text = stringResource(id = R.string.email))
                Spacer(modifier = Modifier.weight(1f))
                Body1(text = user.email)
            }
            Spacer(modifier = Modifier.size(24.dp))
            Divider()
            Spacer(modifier = Modifier.size(24.dp))
            PrimaryButton(
                text = stringResource(id = R.string.logout),
                onClick = onLogout,
                modifier = Modifier.padding(horizontal = 24.dp),
            )
        }
    }
}


@Composable
@Preview(uiMode = UI_MODE_TYPE_NORMAL)
fun ProfileViewPreview() {
    val context = LocalContext.current
    CompositionLocalProvider(LocalContext provides context) {
        AppTheme(useDarkTheme = false) {
            ProfileView(
                user = User(
                    id = "1",
                    name = "Jhon Doe",
                    email = "jhon@gmail.com",
                    username = "jhon_doe",
                )
            )
        }
    }
}