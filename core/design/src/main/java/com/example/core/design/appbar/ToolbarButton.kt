package com.example.core.design.appbar

import com.example.core.design.image.PainterSource

sealed class ToolbarButton(open val painterSource: PainterSource) {
    data class Icon(override val painterSource: PainterSource) : ToolbarButton(painterSource)
    data class Avatar(override val painterSource: PainterSource) : ToolbarButton(painterSource)
}
