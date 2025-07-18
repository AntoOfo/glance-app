package com.antonio.glance.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    // bold text on card?
    bodyLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 11.sp,
        letterSpacing = 0.5.sp
    ),
    // bigger version of bold text?
    titleMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 11.sp,
        letterSpacing = 0.sp
    ),
    // even bigger version of bold text?
    titleLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    // smallest text
    labelSmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Thin,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.5.sp
    ),
    // 2nd smallest
    labelMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 11.sp,
        lineHeight = 13.sp,
        letterSpacing = 0.5.sp
    ),
    // 3rd smallest
    labelLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.2.sp
    )
)