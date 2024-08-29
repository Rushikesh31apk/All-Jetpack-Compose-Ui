package com.rushi.jetpackcompose.Animation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun CrossFadeAnimation() {
	val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Gray)
	var current by remember { mutableStateOf(colors[0]) }
	Column(modifier = Modifier.fillMaxSize()) {
		// Crossfade animation is used when there is change in the screen, like if there
		// is a transition between screens or there is a change in color of the screens or
		// something like that.
		// For example, here onClick of the Box, we are changing the background color of Box
		// by using Crossfade animation.
		Crossfade(targetState = current) { color ->
			Box(
				Modifier
					.fillMaxSize()
					.clickable(onClick = { current = colors.random() })
					.background(color)
			)
			Text(
				modifier = Modifier.fillMaxSize(),
				textAlign = TextAlign.Center,
				text = "Click To See"
			)
		}
	}
}