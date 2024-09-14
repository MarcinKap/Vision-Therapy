package com.example.core.design.image

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter

sealed class PainterSource {

    @Composable
    internal abstract fun painter(): Painter

    data class Resource(@DrawableRes val imageResId: Int) : PainterSource() {
        @Composable
        override fun painter() = painterResource(imageResId)
    }

    data class Async(
        val model: Any,
        val placeholder: PainterSource? = null,
        val error: PainterSource? = null,
        val fallback: PainterSource? = null,
    ) : PainterSource() {
        @Composable
        override fun painter() = rememberAsyncImagePainter(
            model = model,
            placeholder = placeholder?.painter(),
            error = error?.painter(),
            fallback = fallback?.painter(),
        )
    }
}

fun @receiver:DrawableRes Int.toPainterSource() = PainterSource.Resource(this)
