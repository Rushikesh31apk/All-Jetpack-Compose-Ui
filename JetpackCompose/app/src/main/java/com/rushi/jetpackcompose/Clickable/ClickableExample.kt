@file:OptIn(ExperimentalFoundationApi::class)

package com.rushi.jetpackcompose.Clickable

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ClickableExample(modifier: Modifier=Modifier.padding()) {
	Column(
		modifier = Modifier.fillMaxSize().padding(top=100.dp)
	) {
		SimpleButtonComponent()
		Divider(color = Color.Gray)
		SimpleTextComponent()
		Divider(color = Color.Gray)
		SimpleCardComponent()
		Divider(color = Color.Gray)
	}
}

// clickable is used to receive click events from components and perform some action based on
// click event. It supports one click, double click, and long press.

@Composable
fun SimpleButtonComponent() {
	val context = LocalContext.current
	Button(
		onClick = {
			Toast.makeText(context, "Thanks for clicking! I am Button", Toast.LENGTH_SHORT).show()
		},
		modifier = Modifier.padding(16.dp).fillMaxWidth()
	) {
		Text("Click Me")
	}
}

@Composable
fun SimpleTextComponent() {
	val context = LocalContext.current
	Text(
		text = "Click Me",
		textAlign = TextAlign.Center,
		color = Color.Black,
		modifier = Modifier
			.padding(16.dp)
			.fillMaxWidth()
			.combinedClickable(
				onClick = {
					Toast.makeText(context, "Thanks for clicking! I am Text", Toast.LENGTH_SHORT).show()
				},
				onLongClick = {
					Toast.makeText(context, "Thanks for LONG click! I am Text", Toast.LENGTH_SHORT).show()
				}
			)
			.pointerInput(Unit) {
				detectTapGestures(
					onDoubleTap = {
						Toast.makeText(context, "Thanks for DOUBLE click! I am Text", Toast.LENGTH_SHORT).show()
					}
				)
			}
	)
}


@Composable
fun SimpleCardComponent() {
	val context = LocalContext.current
	Card(
		shape = RoundedCornerShape(4.dp),
		colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA867)),
		modifier = Modifier.padding(16.dp).fillMaxWidth().clickable(onClick = {
			Toast.makeText(context, "Thanks for clicking! I am Card.", Toast.LENGTH_SHORT).show()
		})
	) {
		Text(
			text = "Click Me",
			textAlign = TextAlign.Center,
			style = TextStyle(
				fontSize = 16.sp
			),
			modifier = Modifier.padding(16.dp)
		)
	}
}