package com.example.compose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Box() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopStart
    ) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center

        ) {
            Box(
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
                    .background(Color.Green),
            )
            Text(
                text = "I Love Android",
                fontSize = 40.sp,
            )
        }
    }
}