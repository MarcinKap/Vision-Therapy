package com.example.core.design.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.design.iconbutton.IconButton
import com.example.core.design.image.Image
import com.example.core.design.spacer.HorizontalSpacer
import com.example.core.design.theme.VisionAppTheme

const val TEST_TAG_TOOLBAR_NAV_ACTION = "test_tag:toolbar_nav_action"

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    navigationAction: ToolbarLeadingAction? = null,
    backgroundColor: Color = Color.White,
    contentPadding: PaddingValues = AppBarDefaults.ContentPadding,
    elevation: Dp = AppBarDefaults.TopAppBarElevation,
) {
    TopAppBar(
        modifier = modifier
            .height(64.dp)
            .fillMaxWidth(),
        backgroundColor = backgroundColor,
        elevation = elevation,
        contentPadding = contentPadding,
        content = {
            navigationAction?.let { action ->
                NavigationAction(
                    action = action,
                )
            } ?: Spacer(modifier = Modifier.padding(start = 16.dp))

            title?.let { title ->
                Text(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f),
                    text = title,
                )
            } ?: Spacer(modifier = Modifier.weight(1f))
        },
    )
}

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    navigationAction: ToolbarLeadingAction? = null,
    backgroundColor: Color = Color.White,
    contentPadding: PaddingValues = AppBarDefaults.ContentPadding,
    elevation: Dp = AppBarDefaults.TopAppBarElevation,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        elevation = elevation,
    ) {
        Column {
            TopAppBar(
                modifier = modifier.height(64.dp),
                backgroundColor = backgroundColor,
                elevation = 0.dp,
                contentPadding = contentPadding,
                content = {
                    navigationAction?.let { action ->
                        NavigationAction(
                            action = action,
                        )
                    } ?: Spacer(modifier = Modifier.padding(start = 16.dp))

                    title?.let { title ->
                        Text(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.weight(1f),
                            text = title,
                        )
                    } ?: Spacer(modifier = Modifier.weight(1f))
                },
            )
            content()
        }
    }
}

@Composable
private fun NavigationAction(
    action: ToolbarLeadingAction,
) {
    require(action.button != null) { "Navigation action must have an icon" }

    when (action.button) {
        is ToolbarButton.Icon -> {
            IconButton(
                painterSource = action.button.painterSource,
                onClick = action::invoke,
            )
        }

        is ToolbarButton.Avatar -> {
            Box(
                modifier = Modifier
                    .testTag(action.testTag ?: TEST_TAG_TOOLBAR_NAV_ACTION)
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colorScheme.surfaceVariant, shape = CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .clickable(
                            onClick = action::invoke,
                        ),
                )
                Image(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape),
                    painterSource = action.button.painterSource,
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                )
            }
            HorizontalSpacer(width = 10.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarPreview() {
    VisionAppTheme {
        TopAppBar(
            title = "Title",
            navigationAction = ToolbarLeadingAction.Back(onBackClicked = {}),
        )
    }
}
