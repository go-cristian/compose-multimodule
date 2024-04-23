package com.baubap.ds.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baubap.common.UnitFunction
import com.baubap.ds.ui.theme.AppTheme
import com.baubap.ds.ui.theme.Black
import com.baubap.ds.ui.theme.White
import com.baubap.ds.ui.theme.orInDarkTheme
import com.baubap.ds.ui.theme.primaryButtonBackgroundColor
import com.baubap.ds.ui.theme.primaryButtonBorderColor
import com.baubap.ds.ui.theme.primaryButtonDisabledTextColor
import com.baubap.ds.ui.theme.primaryButtonTextColor
import com.baubap.ds.ui.theme.secondaryButtonTextColor

enum class Variant {
    PRIMARY,
    BORDERLESS,
}

@Preview
@Composable
fun PrimaryButtonEnabledPreview() {
    AppTheme(useDarkTheme = false) {
        PrimaryButton(
            text = "Primary Button",
            onClick = {},
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PrimaryButtonDarkkThemePreview() {
    AppTheme(useDarkTheme = true) {
        PrimaryButton(
            text = "Primary Button",
            onClick = {},
        )
    }
}

@Preview
@Composable
fun PrimaryButtonDisabledPreview() {
    AppTheme(useDarkTheme = false) {
        PrimaryButton(
            text = "Primary Button",
            enabled = false,
            onClick = {},
        )
    }
}

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    useShape: Boolean = true,
    onClick: UnitFunction = {},
) {
    BaseButton(
        text,
        enabled = enabled,
        variant = Variant.PRIMARY,
        useShape = useShape,
        onClick = onClick,
        modifier = modifier
            .height(54.dp)
            .fillMaxWidth()
    )
}

@Composable
fun BaseButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    useShape: Boolean = true,
    leadingIcon: Int? = null,
    trailingIcon: Int? = null,
    variant: Variant = Variant.BORDERLESS,
    onClick: UnitFunction = {},
) {
    val iconColor = textColorFrom(variant, enabled)
    val disabledContentColor = Black orInDarkTheme White
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorFrom(variant),
            disabledContainerColor = Color.Transparent,
            contentColor = textColorFrom(variant, enabled),
            disabledContentColor = disabledContentColor,
        ),
        elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp),
        border = if (useShape) borderFrom(variant) else null,
        shape = if (useShape) shapeFrom(variant) else RoundedCornerShape(0.dp),
        enabled = enabled,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (leadingIcon != null) {
                Icon(
                    painterResource(id = leadingIcon),
                    contentDescription = null,
                    tint = iconColor,
                )
            }
            if (variant == Variant.BORDERLESS) {
                Body4Medium(
                    modifier = Modifier
                        .padding(start = if (leadingIcon == null) 0.dp else 6.dp)
                        .padding(end = if (trailingIcon == null) 0.dp else 6.dp),
                    text = text,
                    color = textColorFrom(variant, enabled),
                    textAlign = TextAlign.Center,
                )
            } else {
                Body2(
                    text = text,
                    color = textColorFrom(variant, enabled),
                    textAlign = TextAlign.Center,
                )
            }
            if (trailingIcon != null) {
                Icon(
                    painterResource(id = trailingIcon),
                    contentDescription = null,
                    tint = iconColor,
                )
            }
        }
    }
}

@Composable
fun borderFrom(variant: Variant) = when (variant) {
    Variant.PRIMARY -> BorderStroke(1.dp, primaryButtonBorderColor)
    else -> null
}

@Composable
fun shapeFrom(variant: Variant) = when (variant) {
    Variant.PRIMARY -> RoundedCornerShape(50)
    Variant.BORDERLESS -> RoundedCornerShape(0)
}

@Composable
fun backgroundColorFrom(variant: Variant): Color {
    return when (variant) {
        Variant.PRIMARY -> primaryButtonBackgroundColor
        Variant.BORDERLESS -> Color.Transparent
    }
}

@Composable
fun textColorFrom(variant: Variant, enabled: Boolean): Color {
    if (!enabled) {
        return primaryButtonDisabledTextColor
    }
    return when (variant) {
        Variant.PRIMARY -> primaryButtonTextColor
        Variant.BORDERLESS -> secondaryButtonTextColor
    }
}