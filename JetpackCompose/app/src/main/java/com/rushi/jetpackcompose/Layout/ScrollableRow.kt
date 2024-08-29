package com.rushi.jetpackcompose.Layout

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rushi.jetpackcompose.Data.Blog

@Composable
fun ScrollableRowComponent(blogList: List<Blog>) {
	val scrollState = rememberScrollState()

	Row(
		modifier = Modifier
			.fillMaxWidth()
			.horizontalScroll(scrollState)
	) {
		for (blog in blogList) {
			Card(
				shape = RoundedCornerShape(4.dp),
				modifier = Modifier
					.padding(16.dp)
					.width(200.dp), // Adjust width as needed
				colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA867))
			) {
				Text(
					text = blog.name,
					style = TextStyle(
						fontSize = 16.sp
					),
					modifier = Modifier.padding(16.dp)
				)
			}
		}
	}
}
