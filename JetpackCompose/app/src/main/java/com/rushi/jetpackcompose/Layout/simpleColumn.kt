package com.rushi.jetpackcompose.Layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SimpleColumnComponent() {
	// Column is used to keep the child vertically.
	Column(modifier = Modifier.padding(top=100.dp),
		horizontalAlignment = Alignment.CenterHorizontally) {
		Text(text = "Hello! I am Text 1", color = Color.Black)
		Text(text = "Hello! I am Text 2", color = Color.Blue)
		Text(text = "Hello! I am Text 3", color = Color.Red)
		Text(text = "Hello! I am Text 4", color = Color.Green)
	}
}

