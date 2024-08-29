package com.rushi.jetpackcompose.Layout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import com.rushi.jetpackcompose.Data.Blog

@Composable
fun ScrollableColumnComponent(blogList: List<Blog>) {
	val context = LocalContext.current
	val scrollState = rememberScrollState()

	Column(
		modifier = Modifier
			.fillMaxSize()
			.verticalScroll(scrollState)
	) {
		for (blog in blogList) {
			Card(
				shape = RoundedCornerShape(4.dp),
				modifier = Modifier
					.fillMaxWidth()
					.padding(16.dp)
					.clickable {
						Toast.makeText(context, "Author: ${blog.author}", Toast.LENGTH_SHORT).show()
					},
				colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA867))
			) {
				Text(
					text = blog.name,
					style = TextStyle(
						fontSize = 16.sp,
						textAlign = TextAlign.Center
					),
					modifier = Modifier.padding(16.dp)
				)
			}
		}
	}
}
