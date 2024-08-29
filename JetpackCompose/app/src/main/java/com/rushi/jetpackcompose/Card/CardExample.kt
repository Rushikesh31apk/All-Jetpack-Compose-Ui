package com.rushi.jetpackcompose.Card

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardExample(modifier: Modifier=Modifier.padding()) {
	Column(
		modifier = Modifier.fillMaxSize().padding(top=100.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		SimpleCardComponent()
		Divider(color = Color.Gray)
		RoundedCornerCardComponent()
		Divider(color = Color.Gray)
		ClickableCardComponent()
		Divider(color = Color.Gray)
		BorderedCardComponent()
		Divider(color = Color.Gray)
	}

}

@Composable
fun SimpleCardComponent() {
	Card(
		modifier = Modifier
			.padding(16.dp),
		colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA867))
	) {
		Text(
			text = "Simple Card",
			textAlign = TextAlign.Center,
			fontSize = 20.sp,
			modifier = Modifier.padding(16.dp)
		)
	}
}


@Composable
fun RoundedCornerCardComponent() {
	Card(
		shape = RoundedCornerShape(8.dp),
		colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA867)),
		modifier = Modifier.padding(16.dp)
	) {
		Text(
			text = "Rounded Corner Card",
			textAlign = TextAlign.Center,
			fontSize = 16.sp,
			modifier = Modifier.padding(16.dp)
		)
	}
}

@Composable
fun ClickableCardComponent() {
	val context = LocalContext.current
	Card(
		shape = RoundedCornerShape(8.dp),
		colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA867)),
		modifier = Modifier.padding(16.dp).clickable(onClick = {
			Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_SHORT).show()
		})
	) {
		Text(
			text = "Clickable Card",
			textAlign = TextAlign.Center,
			fontSize = 16.sp,
			modifier = Modifier.padding(16.dp)
		)
	}
}

@Composable
fun BorderedCardComponent() {
	Card(
		shape = RoundedCornerShape(8.dp),
		colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA867)),
		border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Green)),
		modifier = Modifier.padding(16.dp)
	) {
		Text(
			text = "Bordered Card",
			textAlign = TextAlign.Center,
			style = TextStyle(
				fontSize = 16.sp
			),
			modifier = Modifier.padding(16.dp)
		)
	}
}