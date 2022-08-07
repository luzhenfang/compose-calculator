package com.lu.calculate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.lu.calculate.common.CalculatorScaffold
import com.lu.calculate.ui.theme.CalculateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculateTheme {
                Surface(modifier = Modifier
                    .fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    // Material design 脚手架
                    CalculatorScaffold("Jetpack Compose Calculator", R.drawable.logo)
                }
            }
        }
    }
}



