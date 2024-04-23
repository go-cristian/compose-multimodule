@file:OptIn(ExperimentalComposeUiApi::class)

package com.baubap.login.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baubap.common.isEmail
import com.baubap.common.stateOf
import com.baubap.ds.components.IconValue
import com.baubap.ds.components.InputField
import com.baubap.ds.components.PrimaryButton
import com.baubap.ds.components.Title
import com.baubap.ds.ui.theme.AppTheme
import com.baubap.ds.ui.theme.Black
import com.baubap.ds.ui.theme.White
import com.baubap.ds.ui.theme.orInDarkTheme
import com.baubap.login.R

object Colors {
    val title
        @Composable
        get() = Black orInDarkTheme White
}

@Composable
fun LoginView(
    onLogin: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusController = LocalFocusManager.current
    Surface {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Bottom),
        ) {
            var email by stateOf(TextFieldValue())
            var password by stateOf(TextFieldValue())
            var passwordKeyboardType by stateOf(KeyboardType.Password)

            Title(
                text = stringResource(R.string.description),
                color = Colors.title,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.size(24.dp))
            InputField(
                textState = email,
                onChanged = { email = it },
                placeholder = stringResource(id = R.string.email_label),
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                imeActionCallback = { focusController.moveFocus(FocusDirection.Down) },
                startIcon = IconValue(
                    icon = Icons.Default.Email,
                    description = stringResource(id = R.string.email_label),
                ),
                endIcon = if (email.text.isNotEmpty()) IconValue(
                    icon = Icons.Default.Clear,
                    description = stringResource(id = R.string.email_label),
                    onClick = { email = TextFieldValue() }
                ) else null
            )
            InputField(
                textState = password,
                onChanged = { password = it },
                placeholder = stringResource(id = R.string.pass_label),
                keyboardType = passwordKeyboardType,
                imeAction = ImeAction.Done,
                imeActionCallback = { keyboardController?.hide() },
                startIcon = IconValue(
                    icon = Icons.Filled.Key,
                    description = stringResource(id = R.string.email_label),
                ),
                endIcon = if (password.text.isNotEmpty()) IconValue(
                    icon = if (passwordKeyboardType == KeyboardType.Password) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Default.VisibilityOff
                    },
                    description = stringResource(id = R.string.email_label),
                    onClick = {
                        passwordKeyboardType = if (passwordKeyboardType == KeyboardType.Password) {
                            KeyboardType.Ascii
                        } else {
                            KeyboardType.Password
                        }
                    }
                ) else null
            )
            Spacer(modifier = Modifier.size(24.dp))
            PrimaryButton(
                text = stringResource(id = R.string.login_label),
                enabled = email.text.isEmail() && password.text.isNotEmpty(),
                onClick = {
                    keyboardController?.hide()
                    onLogin(email.text, password.text)
                }
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
            LoginView(onLogin = { _, _ -> })
        }
    }
}

@Composable
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
)
fun LoginViewDarkThemePreview() {
    val context = LocalContext.current
    CompositionLocalProvider(LocalContext provides context) {
        AppTheme(useDarkTheme = true) {
            LoginView(onLogin = { _, _ -> })
        }
    }
}