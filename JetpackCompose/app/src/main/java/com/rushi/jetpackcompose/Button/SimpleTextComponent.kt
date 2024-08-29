package com.rushi.jetpackcompose.Button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun SimpleTextComponent(text: String="Simple Text") {
	Text(
		text = text,
		style = TextStyle(
			fontSize = 16.sp,
			color = Color.Black
		),
		modifier = Modifier.padding(16.dp).fillMaxWidth()
	)
}