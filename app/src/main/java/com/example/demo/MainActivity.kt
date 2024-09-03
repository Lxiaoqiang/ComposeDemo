package com.example.demo

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.bean.response.BannerBean
import com.example.demo.component.showToast
import com.example.demo.ext.UIState
import com.example.demo.ext.load
import com.example.demo.ui.theme.DemoTheme
import com.example.demo.viewmodel.HomeViewModel
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.indicator.CircleIndicator

class MainActivity : ComponentActivity() {


    val mViewModel: HomeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            DemoTheme {
                val navController = rememberNavController()
                    Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                ) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        AppNavGraph(navHostController = navController) {
                            finish()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoTheme {
        Greeting("Android")
    }
}

@Composable
fun BannerView(viewModel: HomeViewModel) {
    val uiState = viewModel.bannerData.observeAsState()
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        factory = { ctx ->
            val banner = Banner<BannerBean, MyBannerAdapter>(ctx)
            val bannerAdapter = MyBannerAdapter()
            banner.setAdapter(bannerAdapter)
            banner.setIndicator(CircleIndicator(ctx))
        },
        update = { view ->
            when (uiState.value) {
                is UIState.Success -> {
                    view.setDatas((uiState.value as UIState.Success).data)
                }

                is UIState.Error -> {
                    showToast((uiState.value as UIState.Error).error.errorMsg)
                }

                is UIState.Loading -> {}
                else -> {}
            }
        }
    )
}

class MyBannerAdapter : BannerAdapter<BannerBean, MyBannerAdapter.BannerAdapterVH>(null) {

    class BannerAdapterVH(val iv: ImageView) : RecyclerView.ViewHolder(iv)

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerAdapterVH {
        return BannerAdapterVH(ImageView(parent!!.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            scaleType = ImageView.ScaleType.CENTER_CROP
        })
    }

    override fun onBindView(holder: BannerAdapterVH, data: BannerBean, position: Int, size: Int) {
        holder.iv.load(data.imagePath)
    }
}