package com.lu.calculate.common

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lu.calculate.DrawerContent
import kotlinx.coroutines.launch


// 计算器脚手架
@Composable
fun CalculatorScaffold(title: String, @DrawableRes logo: Int) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()


    // logo 旋转动画
    val rotateState by rememberInfiniteTransition().animateFloat(initialValue = 0f,
        targetValue = (360..720).random().toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = (2000..5000).random(),
                easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ))


    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            // 侧边抽屉
            DrawerContent()
        },
        modifier = Modifier.background(MaterialTheme.colors.primary),
        topBar = {
            TopAppBar() {
                // 顶部 logo 标题
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(modifier = Modifier
                        .size(48.dp)
                        .rotate(rotateState)
                        .clickable {
                            scope.launch {
//                                                scaffoldState.snackbarHostState.showSnackbar("呜~你发现了世外桃源",)
                                scaffoldState.drawerState.open()

                            }
                        },
                        painter = painterResource(id = logo),
                        contentDescription = "logo")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = title,
                        style = MaterialTheme.typography.h6)
                }
            }
        }
    ) {
        // 计算器主体内容
        CalculatorBody()
    }
}