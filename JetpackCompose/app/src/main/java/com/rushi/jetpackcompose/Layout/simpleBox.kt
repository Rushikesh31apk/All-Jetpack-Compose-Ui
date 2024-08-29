package com.rushi.jetpackcompose.Layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rushi.jetpackcompose.R

@Composable
fun SimpleBoxComponent() {
	// A Box is a layout composable that is used to place children relative to its edges.
	// Initially, Stack was used in place of Box. But now, Stack is deprecated and Box is introduced.
	// As the name suggests, the children are placed inside parent.
	Box(modifier = Modifier
		.fillMaxSize()
		.padding(top=100.dp)) {
		Image(painter = painterResource(id = R.drawable.omkar), contentDescription = null)
		Text(
			modifier = Modifier.padding(start = 16.dp, top = 16.dp),
			text = "I am a text over Image",
			fontSize = 16.sp,
			color = Color.Red
		)
	}
}