package com.lu.calculate

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lu.calculate.common.NumPad
import com.lu.calculate.common.NumberBoard
import com.lu.calculate.ui.theme.CalculateTheme

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {

}

@Preview(showBackground = true)
@Composable
fun NumPadPreview() {
    NumPad()
}
