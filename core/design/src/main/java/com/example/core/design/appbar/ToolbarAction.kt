package com.example.core.design.appbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.core.design.R
import com.example.core.design.image.PainterSource

const val TEST_TAG_AVATAR_BUTTON = "test_tag:avatar_button"
const val TEST_TAG_BACK_BUTTON = "test_tag:back_button"

sealed class ToolbarAction(
    open val painterSource: PainterSource? = null,
    open val contentColor: Color? = null,
    open val testTag: String? = null,
    open val enabled: Boolean = true,
    private val onClick: () -> Unit,
) {
    operator fun invoke() {
        if (enabled) onClick()
    }
}

data class ToolbarLeadingAction(
    val button: ToolbarButton? = null,
    override val contentColor: Color? = null,
    override val testTag: String? = null,
    override val enabled: Boolean = true,
    private val onClick: () -> Unit,
) : ToolbarAction(button?.painterSource, contentColor, testTag, enabled, onClick) {
    object Avatar {
        @Composable
        operator fun invoke(
            avatarUrl: String,
            onAvatarClicked: () -> Unit,
        ): ToolbarLeadingAction {
            val context = LocalContext.current
            val imageRequest = ImageRequest.Builder(context)
                .data(avatarUrl)
                .placeholder(R.drawable.baseline_person_24)
                .error(R.drawable.baseline_person_24)
                .fallback(R.drawable.baseline_person_24)
                .transformations(CircleCropTransformation())
                .crossfade(true)
                .build()

            return ToolbarLeadingAction(
                button = ToolbarButton.Avatar(
                    painterSource = PainterSource.Async(imageRequest),
                ),
                onClick = onAvatarClicked,
                contentColor = null,
                testTag = TEST_TAG_AVATAR_BUTTON,
            )
        }
    }

    object Back {
        operator fun invoke(
            contentColor: Color? = null,
            onBackClicked: () -> Unit,
        ) = ToolbarLeadingAction(
            button = ToolbarButton.Icon(PainterSource.Resource(R.drawable.baseline_arrow_back_24)),
            onClick = onBackClicked,
            contentColor = contentColor,
            testTag = TEST_TAG_BACK_BUTTON,
        )
    }
}
