package com.example.bottomnaviagtionbar.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.core.translations.R.string as S
import com.example.core.design.R.drawable as DS

data class BottomNavigationPreviewData(
    val selected: Boolean,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    @DrawableRes val activeIcon: Int,
)

val previewBottomNavigationDataSelected = BottomNavigationPreviewData(
    selected = true,
    title = S.root_home,
    icon = DS.outline_home_24,
    activeIcon = DS.baseline_home_24,
)

val previewBottomNavigationDataNotSelected = BottomNavigationPreviewData(
    selected = false,
    title = S.root_home,
    icon = DS.outline_home_24,
    activeIcon = DS.baseline_home_24,
)

internal class BottomNavItemViewPreviewParameterProvider :
    PreviewParameterProvider<BottomNavigationPreviewData> {
    override val values: Sequence<BottomNavigationPreviewData> = sequenceOf(
        previewBottomNavigationDataSelected,
        previewBottomNavigationDataNotSelected,
    )
}

val previewBottomNavItemList = listOf(
    previewBottomNavigationDataSelected,
    previewBottomNavigationDataNotSelected,
)
