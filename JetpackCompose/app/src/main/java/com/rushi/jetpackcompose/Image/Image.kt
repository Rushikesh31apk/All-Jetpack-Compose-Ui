package com.rushi.jetpackcompose.Image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rushi.jetpackcompose.R

@Composable
fun imageex(){
	Column(
		modifier = Modifier
			.fillMaxSize()
			.verticalScroll(rememberScrollState())
			.padding(20.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	)
	{
		Text(
			modifier = Modifier.fillMaxWidth().padding(16.dp),
			text = "This is a Simple Image"
		)
		SimpleImageComponent()
		Text(
			modifier = Modifier.fillMaxWidth().padding(16.dp),
			text = "This is an image with rounded corners"
		)
		RoundedImageComponent()
		Text(
			modifier = Modifier.fillMaxWidth().padding(16.dp),
			text = "This is an image with rounded corners"
		)
		RoundedImageComponent1()

	}
}


@Composable
fun SimpleImageComponent() {
	// Image is a composable that is used to display some image.
	val image =R.drawable.photo
	Column(
		modifier = Modifier.padding(16.dp)
	) {
		Image(painter = painterResource(id = image), contentDescription = "MindOrks Logo")
	}
}

@Composable
fun RoundedImageComponent() {
	val image = R.drawable.rushiwhite
	Column(
		modifier = Modifier.padding(16.dp)
	) {
		// contentScale is used to find the scaling aspect ratio
		Image(
			painter = painterResource(id = image),
			contentDescription = null, // Consider providing a content description for accessibility
			modifier = Modifier
				.fillMaxWidth()
				.clip(RoundedCornerShape(8.dp)),
			contentScale = ContentScale.Fit
		)

	}
}
@Composable
fun RoundedImageComponent1() {
	val image = R.drawable.omkar
	Column(
		modifier = Modifier.padding(16.dp)
	) {
		// contentScale is used to find the scaling aspect ratio
		Image(
			painter = painterResource(id = image),
			contentDescription = null, // Consider providing a content description for accessibility
			modifier = Modifier
				.fillMaxWidth()
				.clip(RoundedCornerShape(8.dp)),
			contentScale = ContentScale.Fit
		)

	}
}