package com.lu.calculate

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// 侧边抽屉内容
@Composable
fun DrawerContent() {
    val introText = listOf("新建工程，创建项目",
        "构思代码，编写界面",
        "完善配色，实现功能",
        "Jetpack 真的很强大,让我感受到了前所未有的快乐",
        "从 Google 团队的 JetpackCompose 快速入门教程中了解到了Jetpack compose",
        "一开始就被其灵活的语法所吸引",
        "布局简单，高效灵活",
        "添加了logo旋转动画",
        "适配黑夜模式",
        "==========分割线===========",
        "从学习Jetpack Compose 到编写这个项目大概用了一周的时间",
        "因此整体代码质量稍显逊色",
        "本项目 为 Compose学习挑战赛 参赛作品",
        "真心希望 Jetpack Compose 越来越好",
        "by:凉拌西蓝花 (luzhenfang)",
        "blog:https://lzfblog.cn/",
        "The End")
    Text(text = "Hello Jetpack Compose", style = MaterialTheme.typography.h5)
    LazyColumn() {
        items(introText) {
            Card(elevation = 5.dp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.primary) {
                Text(text = it, modifier = Modifier.padding(20.dp), color = Color.White)
            }
        }
    }
}
