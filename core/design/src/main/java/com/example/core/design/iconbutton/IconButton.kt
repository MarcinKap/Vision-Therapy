package com.example.core.design.iconbutton

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.design.image.Icon
import com.example.core.design.image.PainterSource

@Composable
fun IconButton(
    painterSource: PainterSource,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentDescription: String? = null,
) {
    androidx.compose.material3.IconButton(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
    ) {
        Icon(
            painterSource = painterSource,
            contentDescription = contentDescription,
        )
    }
}
