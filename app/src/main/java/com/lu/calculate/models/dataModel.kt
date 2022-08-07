package com.lu.calculate.models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DataModel : ViewModel() {
    val expr = mutableStateOf("")
        get() = field
    val result = mutableStateOf("")
        get() = field

    val preExpr = mutableStateOf("")
        get() = field

    val operate = mutableStateOf("")
        get() = field

    var visible = mutableStateOf(false)
        get() = field

}