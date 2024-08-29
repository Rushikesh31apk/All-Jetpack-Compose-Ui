package com.rushi.jetpackcompose.Layout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.rushi.jetpackcompose.Data.getBlogList

// Ensure the Blog data class is defined correctly
@Composable
fun BlogListScreen() {
	val blogList = getBlogList()
	LazyColumnScrollableComponent(blogList = blogList)
}
@Composable
fun LazyColumnScrollableComponent(blogList: List<Blog>) {
	val context = LocalContext.current
	LazyColumn(
		modifier = Modifier.fillMaxHeight()
	) {
		items(blogList) { blog ->
			Card(
				shape = RoundedCornerShape(4.dp),
				modifier = Modifier
					.fillMaxWidth()
					.padding(16.dp)
					.clickable {
						// Make sure `context` is valid and `blog` is correctly accessed
						Toast.makeText(context, "Author: ${blog.author}", Toast.LENGTH_SHORT).show()
					},
				colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA867))
			) {
				Text(
					text = blog.name, // Ensure that `blog.name` is a String
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