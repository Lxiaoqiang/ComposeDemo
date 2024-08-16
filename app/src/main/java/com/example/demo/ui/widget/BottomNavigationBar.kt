package com.example.demo.ui.widget

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo.ui.theme.AppColorsProvider
import kotlinx.coroutines.launch

/**
 * Created by ssk on 2022/4/17.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    pagerState: PagerState,
    selectedIndex: Int = 0,
    onItemSelected: ((selectedIndex: Int) -> Unit)? = null
) {
    val scope = rememberCoroutineScope()
    BottomNavigation(backgroundColor = AppColorsProvider.current.background) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                label = {
                    BottomNavigationItemText(
                        item.title,
                        if (selectedIndex == index) AppColorsProvider.current.primary else Color.LightGray
                    )
                },
                selected = selectedIndex == index,
                onClick = {
                    scope.launch {
                        pagerState.scrollToPage(index)
                        onItemSelected?.invoke(index)
                    }
                },
                icon = {
                    BottomNavigationItemIcon(
                        item.icon,
                        if (selectedIndex == index) AppColorsProvider.current.primary else Color.LightGray
                    )
                },
            )
        }
    }
}


@Composable
private fun BottomNavigationItemIcon(@DrawableRes resId: Int, color: Color) {
    Icon(
        painterResource(resId),
        null,
        tint = color,
        modifier = Modifier.size(22.dp)
    )
}

@Composable
private fun BottomNavigationItemText(text: String, color: Color) {
    Text(
        text,
        color = color,
        fontSize = 10.sp
    )
}

data class BottomNavigationItem(val title: String, val icon: Int)