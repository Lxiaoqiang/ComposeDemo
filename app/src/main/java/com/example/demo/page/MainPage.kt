package com.example.demo.page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.demo.R
import com.example.demo.page.home.HomePage
import com.example.demo.page.mine.MinePage
import com.example.demo.page.sys.SysPage
import com.example.demo.ui.widget.BottomNavigationBar
import com.example.demo.ui.widget.BottomNavigationItem

private val bottomNavigationItems = listOf(
    BottomNavigationItem("首页", R.drawable.home),
    BottomNavigationItem("知识", R.drawable.book),
    BottomNavigationItem("我的", R.drawable.icon_mine)
)

var selectedHomeTabIndex by mutableIntStateOf(0)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainPage() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        val pageState = rememberPagerState(initialPage = 0) {
            3
        }

        HorizontalPager(
            modifier = Modifier.weight(1F),
            state = pageState
        ) { page: Int ->
            selectedHomeTabIndex = pageState.currentPage
            when(page) {
                0 -> HomePage()
                1 -> SysPage()
                2 -> MinePage()
            }
        }

        BottomNavigationBar(items = bottomNavigationItems, pagerState = pageState, selectedIndex = selectedHomeTabIndex) {
            selectedHomeTabIndex = it
        }
    }
}