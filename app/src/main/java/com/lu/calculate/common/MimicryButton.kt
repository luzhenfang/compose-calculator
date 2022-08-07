@file:JvmName("MimicryButtonKt")

package com.lu.calculate.common

import android.os.Build
import androidx.annotation.RequiresApi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint

import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


fun Modifier.drawColoredShadow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    roundedRect: Boolean = true,
) = this.drawBehind {
    /**将颜色转换为Argb的Int类型*/
    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = .0f).value.toLong())
    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())
    /**调用Canvas绘制*/
    this.drawIntoCanvas {
        val paint = Paint()
        paint.color = Color.Transparent
        /**调用底层fragment Paint绘制*/
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        /**绘制阴影*/
        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        /**形状绘制*/
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            if (roundedRect) this.size.height / 2 else borderRadius.toPx(),
            if (roundedRect) this.size.height / 2 else borderRadius.toPx(),
            paint
        )
    }
}


@Composable
fun MimicryButton(
    title: String = "X",
    onClick: (btn: String) -> Unit,
    modifier: Modifier,
) {

    var color = MaterialTheme.colors.primary

    when (title) {
        "÷" -> color = MaterialTheme.colors.secondary
        "×" -> color = MaterialTheme.colors.secondary
        "－" -> color = MaterialTheme.colors.secondary
        "＋" -> color = MaterialTheme.colors.secondary
        "＝" -> color = MaterialTheme.colors.secondary
    }


    val fontColor = if (color == MaterialTheme.colors.secondary) color else Color.White;


    TextButton(
        modifier = modifier,
        onClick = {
            if (title != "smile") onClick(title) else {
                println("Hello,World!")
            }
        },
    ) {
        if (title == "smile") {
            Icon(imageVector = Icons.Default.Face,
                contentDescription = "smile",
                modifier = Modifier.size(40.dp).align(Alignment.CenterVertically),
                tint = fontColor)
        } else {
            Text(text = title, color = fontColor, fontSize = 30.sp, fontWeight = FontWeight.W700)
        }
    }


}