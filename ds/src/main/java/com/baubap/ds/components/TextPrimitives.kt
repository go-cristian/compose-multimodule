package com.baubap.ds.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.baubap.common.toDp
import com.baubap.ds.ui.theme.Fonts
import com.baubap.ds.ui.theme.bodyColor

@Composable
fun LargeTitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = bodyColor,
    textAlign: TextAlign? = TextAlign.Start,
    underline: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    iconSize: Dp? = null,
    overflow: TextOverflow? = null,
    testTag: String? = null,
) {
    BaseText(
        text = text,
        modifier = modifier,
        variant = TextVariant.LARGE_TITLE,
        color = color,
        textAlign = textAlign,
        underline = underline,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        iconSize = iconSize,
        overflow = overflow,
        testTag = testTag,
    )
}

@Composable
fun Title(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = bodyColor,
    textAlign: TextAlign? = TextAlign.Start,
    underline: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    iconSize: Dp? = null,
    overflow: TextOverflow? = null,
    testTag: String? = null,
) {
    BaseText(
        text = text,
        modifier = modifier,
        variant = TextVariant.TITLE,
        color = color,
        textAlign = textAlign,
        underline = underline,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        iconSize = iconSize,
        overflow = overflow,
        testTag = testTag,
    )
}

@Composable
fun Body1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = bodyColor,
    textAlign: TextAlign? = TextAlign.Start,
    underline: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    iconSize: Dp? = null,
    overflow: TextOverflow? = null,
    testTag: String? = null,
) {
    BaseText(
        text = text,
        modifier = modifier,
        variant = TextVariant.BODY_1,
        color = color,
        textAlign = textAlign,
        underline = underline,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        iconSize = iconSize,
        overflow = overflow,
        testTag = testTag,
    )
}

@Composable
fun Body2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = bodyColor,
    textAlign: TextAlign? = TextAlign.Start,
    underline: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    iconSize: Dp? = null,
    overflow: TextOverflow? = null,
    testTag: String? = null,
) {
    BaseText(
        text = text,
        modifier = modifier,
        variant = TextVariant.BODY_3,
        color = color,
        textAlign = textAlign,
        underline = underline,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        iconSize = iconSize,
        overflow = overflow,
        testTag = testTag,
    )
}

@Composable
fun Body3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = bodyColor,
    textAlign: TextAlign? = TextAlign.Start,
    underline: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    iconSize: Dp? = null,
    overflow: TextOverflow? = null,
    testTag: String? = null,
) {
    BaseText(
        text = text,
        modifier = modifier,
        variant = TextVariant.BODY_4,
        color = color,
        textAlign = textAlign,
        underline = underline,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        iconSize = iconSize,
        overflow = overflow,
        testTag = testTag,
    )
}

@Composable
fun Body4(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = bodyColor,
    textAlign: TextAlign? = TextAlign.Start,
    underline: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    iconSize: Dp? = null,
    overflow: TextOverflow? = null,
    testTag: String? = null,
) {
    BaseText(
        text = text,
        modifier = modifier,
        variant = TextVariant.BODY_4,
        color = color,
        textAlign = textAlign,
        underline = underline,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        iconSize = iconSize,
        overflow = overflow,
        testTag = testTag,
    )
}

@Composable
fun Body4Medium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = bodyColor,
    textAlign: TextAlign? = TextAlign.Start,
    underline: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    iconSize: Dp? = null,
    overflow: TextOverflow? = null,
    testTag: String? = null,
) {
    BaseText(
        text = text,
        modifier = modifier,
        variant = TextVariant.BODY_4_MEDIUM,
        color = color,
        textAlign = textAlign,
        underline = underline,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        iconSize = iconSize,
        overflow = overflow,
        testTag = testTag,
    )
}

@Composable
fun Body4Bold(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = bodyColor,
    textAlign: TextAlign? = TextAlign.Start,
    underline: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    iconSize: Dp? = null,
    overflow: TextOverflow? = null,
    testTag: String? = null,
) {
    BaseText(
        text = text,
        modifier = modifier,
        variant = TextVariant.BODY_4_BOLD,
        color = color,
        textAlign = textAlign,
        underline = underline,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        iconSize = iconSize,
        overflow = overflow,
        testTag = testTag,
    )
}

@Composable
fun BaseText(
    text: String,
    modifier: Modifier = Modifier,
    variant: TextVariant = TextVariant.BODY_1,
    color: Color = bodyColor,
    textAlign: TextAlign? = TextAlign.Start,
    underline: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    iconSize: Dp? = null,
    overflow: TextOverflow? = null,
    testTag: String? = null,
) {
    val style = styleFrom(variant).copy(
        color = color,
        textDecoration = if (underline) TextDecoration.Underline else TextDecoration.None
    )
    val defaultSize = style.fontSize.toDp()
    val iconHeight = iconSize ?: (defaultSize - 3.dp)
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = basedOn(textAlign)
    ) {
        if (leadingIcon != null) {
            Row(
                modifier = Modifier.padding(end = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    leadingIcon,
                    modifier = Modifier.height(iconHeight),
                    tint = color,
                    contentDescription = "",
                )
            }
        }
        Text(
            text = text,
            style = style,
            textAlign = textAlign,
            overflow = overflow ?: TextOverflow.Clip,
            maxLines = if (overflow == TextOverflow.Ellipsis) 1 else Int.MAX_VALUE,
            modifier = testTag?.let { Modifier.testTag(it) } ?: Modifier,
        )
        if (trailingIcon != null) {
            Row(
                modifier = Modifier.padding(start = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    trailingIcon,
                    modifier = Modifier.height(iconHeight),
                    tint = color,
                    contentDescription = "",
                )
            }
        }
    }
}

enum class TextVariant {
    LARGE_TITLE,
    TITLE,
    BODY_1,
    BODY_2,
    BODY_3,
    BODY_4,
    BODY_4_MEDIUM,
    BODY_4_BOLD,
}

fun basedOn(textAlign: TextAlign?): Arrangement.Horizontal {
    return when (textAlign) {
        TextAlign.Left -> Arrangement.Start
        TextAlign.Right -> Arrangement.End
        TextAlign.Center -> Arrangement.Center
        TextAlign.Start -> Arrangement.Start
        TextAlign.End -> Arrangement.End
        TextAlign.Justify -> Arrangement.SpaceEvenly
        else -> Arrangement.Center
    }
}

@Composable
fun styleFrom(variant: TextVariant): TextStyle {
    return when (variant) {
        TextVariant.LARGE_TITLE -> Fonts.LargeTitle
        TextVariant.TITLE -> Fonts.Title
        TextVariant.BODY_1 -> Fonts.Body1
        TextVariant.BODY_2 -> Fonts.Body2
        TextVariant.BODY_3 -> Fonts.Body3
        TextVariant.BODY_4 -> Fonts.Body4
        TextVariant.BODY_4_MEDIUM -> Fonts.CaptionMedium
        TextVariant.BODY_4_BOLD -> Fonts.CaptionBold
    }
}