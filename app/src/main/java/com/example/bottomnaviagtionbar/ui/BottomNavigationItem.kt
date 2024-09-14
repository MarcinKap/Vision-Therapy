package com.example.bottomnaviagtionbar.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.core.design.spacer.VerticalSpacer
import com.example.core.design.theme.VisionAppTheme
import com.example.core.design.R.drawable as DS

@Composable
fun RowScope.BottomNavigationItem(
    selected: Boolean,
    @StringRes title: Int,
    @DrawableRes icon: Int,
    @DrawableRes activeIcon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: BottomNavigationItemColors = BottomNavigationItemDefaults.colors(),
) {
    val iconColor by colors.iconColor(state = selected)
    val textColor by colors.textColor(state = selected)
    val contentColor by colors.contentColor(state = selected)

    val animatedIconColor by animateColorAsState(
        targetValue = iconColor,
        animationSpec = TweenSpec(
            durationMillis = AnimationConstants.DefaultDurationMillis,
            easing = FastOutSlowInEasing,
        ),
        label = "BottomNavigationItemColorAnimation",
    )

    Box(
        modifier = modifier
            .background(contentColor)
            .weight(1f)
            .fillMaxHeight()
            .selectable(
                selected = selected,
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            VerticalSpacer(height = 6.dp)
            Crossfade(targetState = selected, label = "Bottom navigation item selected animation") { isSelected ->
                Icon(
                    painter = painterResource(id = if (isSelected) activeIcon else icon),
                    contentDescription = null,
                    tint = animatedIconColor,
                )
            }
            VerticalSpacer(height = 3.dp)
            Text(
                text = stringResource(id = title),
                color = textColor,
                maxLines = 1,
            )
            VerticalSpacer(height = 4.dp)
        }
    }
}

interface BottomNavigationItemColors {
    @Composable
    fun iconColor(state: Boolean): State<Color>

    @Composable
    fun textColor(state: Boolean): State<Color>

    @Composable
    fun contentColor(state: Boolean): State<Color>
}

@Preview(showBackground = true)
@Composable
private fun BottomNavBarPreview(
    @PreviewParameter(BottomNavItemViewPreviewParameterProvider::class)
    data: BottomNavigationPreviewData,
) {
    VisionAppTheme {
        Row(modifier = Modifier.height(58.dp), verticalAlignment = Alignment.CenterVertically) {
            BottomNavigationItem(
                selected = data.selected,
                icon = DS.outline_home_24,
                activeIcon = DS.baseline_home_24,
                title = R.string.root_home,
                onClick = { },
            )
        }
    }
}