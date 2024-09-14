package com.example.core.design.shadow

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun BoxScope.BottomShadow(
    visible: Boolean,
    modifier: Modifier = Modifier,
    height: Dp = 20.dp,
) {
    AnimatedVisibility(
        modifier = modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
        visible = visible,
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(height)
                .background(
                    brush = Brush.verticalGradient(
                        0f to Color(0x00000000),
                        1f to Color(0xFFEBEBEC),
                    ),
                ),
        )
    }
}