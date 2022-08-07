package com.lu.calculate.utils

import java.lang.Double.parseDouble
import java.lang.Exception
import kotlin.math.exp

var result: Double = 0.0

object CalculatorUtils {
    // 解析表达式
    fun parseExpr(expr: String, op: String): Boolean {
        if (op == "") return false
        val split = expr.split(op)
        if (split.size != 2) return false
        val left = parseNumber(split[0])
        val right = parseNumber(split[1])
        if (left == null || right == null) return false

        result = when (op) {
            "＋" -> left + right
            "－" -> left - right
            "×" -> left * right
            "÷" -> left / right
            "%" -> left % right
            else -> {
                0.0
            }
        }
        return true
    }

    fun getResult(): Double {
        return result
    }
}


// 是转换成数字
fun parseNumber(n1: String): Double? {
    try {
        val d = parseDouble(n1)
        return d
    } catch (e: Exception) {
        return null
    }
}
