package com.rushi.jetpackcompose.Button

import android.graphics.drawable.Icon
import android.provider.CalendarContract.Colors
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SimpleButtonComponent() {
	ScrollState
	Column {
		Spacer(modifier = Modifier.height(8.dp))
		val context = LocalContext.current
		Button(
			onClick = {
				Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
			},
			modifier = Modifier
				.padding(8.dp)
				.fillMaxWidth()
		) {
			Text("Click Me")
		}
		Spacer(modifier = Modifier.height(8.dp))
		Button(
			onClick = {
				Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
			},
			modifier = Modifier
				.padding(8.dp)
				.fillMaxWidth(),
			shape = RoundedCornerShape(12.dp)
		) {
			Text("Click Me")
		}
		Spacer(modifier = Modifier.height(8.dp))
		TextButton(
			onClick = {
				Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
			},
			modifier = Modifier
				.padding(8.dp)
				.fillMaxWidth()
		) {
			Text("Click Me")
		}
		Spacer(modifier = Modifier.height(8.dp))
		Button(
			onClick = {
				Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
			},
			modifier = Modifier
				.padding(8.dp)
				.fillMaxWidth(),
			border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Green))
		) {
			Text("Click Me")
		}
		Spacer(modifier = Modifier.height(8.dp))
		Button(
			onClick = {
				Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
			},
			modifier = Modifier
				.padding(8.dp)
				.fillMaxWidth(),
			border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Green))
		) {
			Text("Click Me")
			Icon(
				imageVector = Icons.Filled.Favorite,
				contentDescription = "Favorite Icon"
			)
		}
		Spacer(modifier = Modifier.height(8.dp))
		Button(
				onClick = {
					Toast.makeText(context, "You clicked me :(", Toast.LENGTH_LONG).show()
				},
		modifier = Modifier
			.padding(8.dp)
			.fillMaxWidth(),
		colors = ButtonDefaults.buttonColors(Color.Red)
		) {
		Text("Don't Click Me")
		Icon(
			imageVector = Icons.Filled.Favorite,
			contentDescription = "Favorite Icon"
		)
	}
		Spacer(modifier = Modifier.height(8.dp))
		Button(
			onClick = {
				Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
			},
			modifier = Modifier
				.padding(8.dp)
				.fillMaxWidth(),
			enabled = false
		) {
			Text("Click Me")

		}
		Spacer(modifier = Modifier.height(8.dp))
		OutlinedButton(
			onClick = {
				Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
			},
			modifier = Modifier
				.padding(8.dp)
				.fillMaxWidth(),
		) {
			Text("Click Me")
		}
		Spacer(modifier = Modifier.height(8.dp))
		IconButton(
			onClick = {
				Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
			},
			modifier = Modifier
				.padding(8.dp)
				.fillMaxWidth(),
		) {
			Icon(
				imageVector = Icons.Filled.Favorite,
				contentDescription = "Favorite Icon"
			)

		}
		Spacer(modifier = Modifier.height(8.dp))
		FloatingActionButton(
			onClick = {
				Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
			},
			modifier = Modifier.padding(8.dp)
		) {
			Icon(
				imageVector = Icons.Filled.Favorite,
				contentDescription = "Favorite Icon"
			)
		}

	}

}







