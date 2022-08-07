package com.lu.calculate.common

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lu.calculate.models.DataModel
import com.lu.calculate.utils.CalculatorUtils


@Composable
fun NumPad() {
    val dataModel: DataModel = viewModel()
    // 最外层容器
    Column(modifier = Modifier
        .background(MaterialTheme.colors.primary)
        .fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {

        Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier
            .background(Color.White.copy(alpha = .2f))
            .wrapContentHeight()
        ) {
            NumberBoard(modifier = Modifier) {
                dataModel.visible.value = false
                // 清空
                if (it == "C") {
                    dataModel.operate.value = ""
                    dataModel.expr.value = ""
                    return@NumberBoard
                }


                // 获取运算符
                if (it == "＋" || it == "－" || it == "×" || it == "÷" || it == "%") {
                    dataModel.operate.value = it
                }

                // 累加表达式
                if (it != "＝") {
                    dataModel.expr.value += it
                    return@NumberBoard
                }

                // 开始计算结果
                val isOk = CalculatorUtils.parseExpr(dataModel.expr.value, dataModel.operate.value)

                // 表达式出现错误
                if (!isOk) return@NumberBoard
                // 获取计算结果
                val result = CalculatorUtils.getResult()
                // 记录之前表达式
                dataModel.preExpr.value = dataModel.expr.value
                // 当前表达式等于结果
                dataModel.expr.value = result.toString()
                // 刷新动画
                dataModel.visible.value = true
            }
        }
    }

}


// 底部操作按钮
@Composable
fun NumberBoard(modifier: Modifier, onClick: (btn: String) -> Unit) {

    Column(modifier = modifier, verticalArrangement = Arrangement.Bottom) {
        // 按钮标题
        val buttons = ArrayList<List<String>>()
        buttons.add(listOf("C", "smile", "%", "÷"))
        buttons.add(listOf("7", "8", "9", "×"))
        buttons.add(listOf("4", "5", "6", "－"))
        buttons.add(listOf("1", "2", "3", "＋"))
        buttons.add(listOf("0", ".", "＝"))

        for (btn in buttons) {
            Row {
                for (item in btn) {
                    MimicryButton(title = item,
                        modifier = Modifier
                            .weight(if (item == "0") 2.0f else 1f)
                            .padding(horizontal = 5.dp, vertical = 8.dp), onClick = onClick)
                }
            }
        }
    }
}
