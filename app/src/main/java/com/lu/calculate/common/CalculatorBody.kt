package com.lu.calculate.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lu.calculate.models.DataModel

// 计算器 状态
// 计算器主体内容区
@Composable
fun CalculatorBody() {
    val dataModel: DataModel = viewModel()

    // 内容区
    Column {
        // 顶部计算步骤区
        AnimatedVisibility(visible = dataModel.visible.value) {
            Text(text = dataModel.preExpr.value,
                color = Color.White.copy(alpha = 0.6f),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary),
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Right)
        }

        // 中间结果区
        Text(text = dataModel.expr.value,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary),
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Right)

        // 底部按钮
        NumPad()
    }

}