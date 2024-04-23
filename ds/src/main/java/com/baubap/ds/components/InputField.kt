package com.baubap.ds.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baubap.common.UnitFunction
import com.baubap.common.onClick
import com.baubap.ds.ui.theme.AppTheme
import com.baubap.ds.ui.theme.Black
import com.baubap.ds.ui.theme.Silver
import com.baubap.ds.ui.theme.White
import com.baubap.ds.ui.theme.orInDarkTheme

private object Colors {
    val background
        @Composable
        get() = Color.Transparent
    val border
        @Composable
        get() = Black orInDarkTheme White
    val icon
        @Composable
        get() = Black orInDarkTheme White
    val placeholder
        @Composable
        get() = Silver
    val text
        @Composable
        get() = Black orInDarkTheme White
}

data class IconValue(
    val icon: ImageVector,
    val description: String,
    val onClick: UnitFunction? = null,
    val tint: Color? = null
)

@Composable
fun InputField(
    textState: TextFieldValue,
    placeholder: String,
    modifier: Modifier = Modifier,
    onChanged: (TextFieldValue) -> Unit = {},
    startIcon: IconValue? = null,
    endIcon: IconValue? = null,
    keyboardType: KeyboardType = KeyboardType.Ascii,
    imeAction: ImeAction = ImeAction.None,
    imeActionCallback: (KeyboardActionScope.() -> Unit)? = null,
) {
    val background = Colors.background
    val fieldBorder = Colors.border
    val placeholderColor = Colors.placeholder

    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .border(1.dp, fieldBorder, CircleShape)
                .background(background)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .background(background),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (startIcon != null) {
                    var iconModifier = Modifier
                        .size(15.dp)
                        .clip(CircleShape)
                    if (startIcon.onClick != null) {
                        iconModifier = iconModifier.onClick(startIcon.onClick)
                    }
                    Icon(
                        startIcon.icon,
                        tint = startIcon.tint ?: Colors.icon,
                        contentDescription = startIcon.description,
                        modifier = iconModifier,
                    )
                }
                BasicTextField(
                    value = textState,
                    onValueChange = {
                        onChanged(it)
                    },
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(18.dp)
                        ) {
                            if (textState.text.isEmpty()) {
                                Body3(
                                    placeholder,
                                    color = placeholderColor,
                                )
                            }
                            innerTextField()
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = keyboardType,
                        imeAction = imeAction,
                        autoCorrect = false,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = if (imeAction == ImeAction.Done) {
                            imeActionCallback
                        } else null,
                        onNext = if (imeAction == ImeAction.Next) {
                            imeActionCallback
                        } else null,
                    ),
                    visualTransformation = if (keyboardType == KeyboardType.Password) {
                        PasswordVisualTransformation()
                    } else {
                        VisualTransformation.None
                    },
                    cursorBrush = SolidColor(Black orInDarkTheme White),
                    textStyle = styleFrom(TextVariant.BODY_4).copy(color = Colors.text),
                    modifier = Modifier
                        .weight(1f)
                        .padding(0.dp)
                        .height(18.dp)
                        .background(background),
                    singleLine = true,
                )
                if (endIcon != null) {
                    var iconModifier = Modifier
                        .size(15.dp)
                        .clip(CircleShape)
                    if (endIcon.onClick != null) {
                        iconModifier = iconModifier.onClick(endIcon.onClick)
                    }
                    Icon(
                        endIcon.icon,
                        contentDescription = endIcon.description,
                        tint = endIcon.tint ?: Colors.icon,
                        modifier = iconModifier,
                    )
                }
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
fun InputFieldPreview() {
    AppTheme(useDarkTheme = isSystemInDarkTheme()) {
        InputField(
            textState = TextFieldValue(),
            placeholder = "Search",
            startIcon = IconValue(
                icon = Icons.Rounded.Email,
                tint = Colors.icon,
                description = "Email",
                onClick = null,
            ),
            endIcon = IconValue(
                icon = Icons.Rounded.Clear,
                tint = Silver,
                description = "Clear",
                onClick = null,
            ),
        )
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    uiMode = UI_MODE_NIGHT_YES,
)
fun InputFieldDarkThemePreview() {
    AppTheme(useDarkTheme = isSystemInDarkTheme()) {
        InputField(
            textState = TextFieldValue(),
            placeholder = "john@doe.com",
            startIcon = IconValue(
                icon = Icons.Rounded.Email,
                tint = Colors.icon,
                description = "Email",
                onClick = null,
            ),
            endIcon = IconValue(
                icon = Icons.Rounded.Clear,
                tint = Silver,
                description = "Clear",
                onClick = null,
            ),
        )
    }
}