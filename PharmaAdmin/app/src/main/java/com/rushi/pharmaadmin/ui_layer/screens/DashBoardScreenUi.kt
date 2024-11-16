package com.rushi.pharmaadmin.ui_layer.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rushi.pharmaadmin.ui_layer.screens.bottombar.BottomBarNavigation

@Composable
fun DashboardScreenUi(navController: NavHostController) {
	var selected by remember { mutableIntStateOf(3) }
	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.BottomEnd
	) {
		LazyColumn(
			modifier = Modifier.fillMaxSize(),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Top
		) {
			item {
				Text("Dashboard Screen")
			}

			item {
				Spacer(modifier = Modifier.padding(bottom = 80.dp))
				Text(text = "")
			}
		}
		Box(
			modifier = Modifier.fillMaxWidth(),
			contentAlignment = Alignment.BottomEnd
		){
			BottomBarNavigation(
				navHostController = navController,
				selectedItem = selected,
				onSelectedItem = {
					selected = it
				}
			)
		}

	}

}