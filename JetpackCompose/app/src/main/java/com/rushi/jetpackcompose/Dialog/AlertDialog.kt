package com.rushi.jetpackcompose.Dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialogEX(){
	Column(
		modifier = Modifier
			.fillMaxSize() // Make the column fill the entire screen
			.verticalScroll(rememberScrollState()) // Enable vertical scrolling
			.padding(50.dp) // Add padding around the content
	){
		AlertDialogComponent()
	}
}
@Composable
fun AlertDialogComponent() {
	val openDialog = remember { mutableStateOf(true) }
	if (openDialog.value) {
		AlertDialog(
			onDismissRequest = { openDialog.value = false },
			title = { Text(text = "Alert Dialog") },
			text = { Text("Hello! I am an Alert Dialog") },
			confirmButton = {
				TextButton(
					onClick = {
						openDialog.value = false
						/* Do some other action */
					}
				) {
					Text("Confirm")
				}
			},
			dismissButton = {
				TextButton(
					onClick = {
						openDialog.value = false
						/* Do some other action */
					}
				) {
					Text("Dismiss")
				}
			},
			iconContentColor = Color.Cyan,
			containerColor = Color.Yellow,
			tonalElevation = AlertDialogDefaults.TonalElevation

		)
	}
}

