package com.rushi.pharmahub.ui_layer.screens.dashboardscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.rushi.pharmahub.ui_layer.screens.dashboardscreen.bottombar.NavigationView

@Composable
fun StockHistoryUi(navController: NavHostController) {
	var selectedItem by remember { mutableStateOf(3) }

	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.BottomEnd
	) {
		LazyColumn(
			modifier = Modifier
				.fillMaxSize()
				.background(Color.White),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Top
		) {

		}
		Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
			NavigationView(
				navController,
				selectedItem = selectedItem,
				onSelectedItem = { selectedItem = it}
			)
		}
	}

}