package com.rushi.jetpackcompose.MaterialDesign

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
	Scaffold(
		bottomBar = {
			BottomNavigation {
				BottomNavigationItem(
					icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
					//label = { Text("Home") },
					selected = true,
					onClick = { /* Do something */ }
				)
				BottomNavigationItem(
					icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Shorts") },
					//label = { Text("Shorts") },
					selected = false,
					onClick = { /* Do something */ }
				)
				BottomNavigationItem(
					icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "Upload",
						tint = Color.Red,
						modifier = Modifier.background(Color.Black))},
					label = { Text("") },
					selected = false,
					onClick = { /* Do something */ }
				)
				BottomNavigationItem(
					icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Subscriptions") },
					//label = { Text("Subscriptions") },
					selected = false,
					onClick = { /* Do something */ }
				)
				BottomNavigationItem(
					icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Library") },
					//label = { Text("Library") },
					selected = false,
					onClick = { /* Do something */ }
				)
			}
		},
		content = {
			Column(
				modifier = Modifier
					.fillMaxSize()
					.background(color = Color(0xFFE0E0E0))
			) {
//				Text(
//					text = "Home",
//					fontSize = 20.sp,
//					fontWeight = FontWeight.Bold,
//					modifier = Modifier
//						.fillMaxWidth()
//						.padding(16.dp)
//				)
//
//				// Other content
			}
		}
	)
}


@Composable
fun BottomNavigationWithoutLabelComponent() {
	var selectedItem by remember { mutableStateOf(0) }
	val items = listOf("Home", "Blogs", "Profile")
	Column(modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Bottom,
		horizontalAlignment = Alignment.CenterHorizontally) {
		BottomNavigation(
			modifier = Modifier
				.padding()
				.fillMaxWidth(),
			backgroundColor = Color.Transparent,
			contentColor = Color.Yellow
		) {
			items.forEachIndexed { index, item ->
				BottomNavigationItem(
					label = { Text(text = item) },
					icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Library") },
					selected = selectedItem == index,
					onClick = { selectedItem = index },
					// alwaysShowLabels is used to set if you want to show the labels always or
					// just for the current item.
				)
			}
		}
	}

}

@Composable
fun BottomNavigationWithLabelComponent() {
	var selectedItem by remember { mutableStateOf(0) }
	val items = listOf("Home", "Blogs", "Profile")
	// BottomNavigation is a Composable that is used to give easy access to some items
	// and are placed at the bottom of the screen so that the user can easily navigate
	// by clicking the items of the BottomNavigation
	BottomNavigation(
		modifier = Modifier.padding(16.dp).fillMaxWidth(),
		backgroundColor = Color.Black,
		contentColor = Color.Yellow
	) {
		items.forEachIndexed { index, item ->
			BottomNavigationItem(
				label = { Text(text = item) },
				icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Library") },
				selected = selectedItem == index,
				onClick = { selectedItem = index },)
		}
	}
}
