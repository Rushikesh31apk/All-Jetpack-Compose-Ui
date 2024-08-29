package com.rushi.jetpackcompose.Layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SimpleRowComponent() {
	// Row is used to keep the child horizontally.
	Row(modifier = Modifier.padding(16.dp)) {
		Text(text = "Hello! I am Text 1", color = Color.Black)
		Text(text = "Hello! I am Text 2", color = Color.Blue)
		Text(text = "Hello! I am Text 3", color = Color.Red)
		Text(text = "Hello! I am Text 4", color = Color.Green)
	}
}