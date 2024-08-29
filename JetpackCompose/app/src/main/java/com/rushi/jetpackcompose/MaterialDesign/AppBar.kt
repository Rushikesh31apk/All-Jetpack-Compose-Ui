package com.rushi.jetpackcompose.MaterialDesign

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rushi.jetpackcompose.Button.SimpleTextComponent

@Composable
fun SimpleScaffoldComponent() {
	Column(modifier = Modifier.fillMaxSize()) {
		SimpleTextComponent(text = "Top Appbar")
		TopAppBarComponent()
		Spacer(modifier = Modifier.padding(top=100.dp))
		SimpleTextComponent(text = "Bottom Appbar")
		BottomAppBarComponent()
	}
}
@Composable
fun BottomAppBarComponent() {
	BottomAppBar(
		modifier = Modifier
			.padding(16.dp)
			.fillMaxWidth()
	) {
		// RowScope is applied automatically within BottomAppBar
		IconButton(onClick = { /* doSomething() */ }) {
			Icon(Icons.Filled.Menu, contentDescription = "Menu")
		}
		Spacer(Modifier.weight(1f))
		IconButton(onClick = { /* doSomething() */ }) {
			Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
		}
		IconButton(onClick = { /* doSomething() */ }) {
			Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent() {
	TopAppBar(
		modifier = Modifier
			.padding(16.dp)
			.fillMaxWidth(),
		title = { Text("App Name") },
		navigationIcon = {
			IconButton(onClick = { /* doSomething() */ }) {
				Icon(Icons.Filled.Menu, contentDescription = "Menu")
			}
		},
		actions = {
			IconButton(onClick = { /* doSomething() */ }) {
				Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
			}
			IconButton(onClick = { /* doSomething() */ }) {
				Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
			}
		}
	)
}
