package com.example.core.design.image

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Icon(
    painterSource: PainterSource,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    size: IconSize = IconSize.SIZE_24_DP,
) {
    androidx.compose.material.Icon(
        painter = painterSource.painter(),
        contentDescription = contentDescription,
        tint = tint,
        modifier = modifier.size(size.value),
    )
}

@SuppressLint("EnumEntry", "ENUM_ENTRY")
enum class IconSize(val value: Dp) {
    SIZE_24_DP(24.dp),
}
