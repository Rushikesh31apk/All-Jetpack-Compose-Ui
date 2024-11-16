package com.rushi.pharmaadmin.ui_layer.screens.bottombar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddHomeWork
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.ContactPage
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.rushi.pharmaadmin.ui.theme.GreenColor
import com.rushi.pharmaadmin.ui_layer.navigation.Dashboard
import com.rushi.pharmaadmin.ui_layer.navigation.Orders
import com.rushi.pharmaadmin.ui_layer.navigation.Products
import com.rushi.pharmaadmin.ui_layer.navigation.UserScreen

@Composable
fun BottomBarNavigation(
	navHostController: NavHostController,
	selectedItem: Int,
	onSelectedItem: (index: Int) -> Unit
) {
	val items = listOf("Users", "product", "Orders", "Admin")
	Box(modifier = Modifier.fillMaxWidth()) {
		BottomNavigation(
			modifier = Modifier
				.padding(bottom = 0.dp, start = 0.dp, end = 0.dp)
				.clip(
					RoundedCornerShape(
						topStartPercent = 60,
						topEndPercent = 60,
						bottomStartPercent = 0,
						bottomEndPercent = 0
					)
				),
			backgroundColor = GreenColor
		) {
			items.forEachIndexed { index, item ->
				BottomNavigationItem(
					selected = selectedItem == index,
					onClick = {
						onSelectedItem(index)
						when (index) {
							0 -> navHostController.navigate(UserScreen) {
								popUpTo(UserScreen) {
									saveState = true
								}
								launchSingleTop = true
								restoreState = true
							}

							1 -> navHostController.navigate(Products) {
								popUpTo(UserScreen) {
									saveState = true
								}
								launchSingleTop = true
								restoreState = true
							}

							2 -> navHostController.navigate(Orders) {
								popUpTo(UserScreen) {
									saveState = true
								}
								launchSingleTop = true
								restoreState = true
							}

							3 -> navHostController.navigate(Dashboard) {
								popUpTo(UserScreen) {
									saveState = true
								}
								launchSingleTop = true
								restoreState = true
							}
						}
					},
					icon = {
						when (index) {
							0 -> Icon(
								imageVector = Icons.Default.Person,
								contentDescription = null,
								tint = if (selectedItem==index){Color.Black}else{Color.White},
								modifier = Modifier.size(
									if (selectedItem == index) {
										35.dp
									} else {
										24.dp
									}
								)
							)

							1 -> Icon(
								imageVector = Icons.Default.Shop,
								contentDescription = null,
								tint = if (selectedItem==index){Color.Black}else{Color.White},
								modifier = Modifier.size(
									if (selectedItem == index) {
										35.dp
									} else {
										24.dp
									}
								)

							)

							2 -> Icon(
								imageVector = Icons.Default.AddShoppingCart,
								contentDescription = null,
								tint = if (selectedItem==index){Color.Black}else{Color.White},
								modifier = Modifier.size(
									if (selectedItem == index) {
										35.dp
									} else {
										24.dp
									}
								)
							)

							3 -> Icon(
								imageVector = Icons.Default.Android,
								contentDescription = null,
								tint = if (selectedItem==index){Color.Black}else{Color.White},
								modifier = Modifier.size(
									if (selectedItem == index) {
										35.dp
									} else {
										24.dp
									}
								)
							)
						}
					},
					label = {
						Spacer(modifier = Modifier.padding(top = 3.dp))
						Text(
							text = items[index], style = TextStyle(

								color =if(selectedItem == index) {
									Color.Black
								}else{
									Color.White
								},
								fontSize = if (selectedItem == index) {
									11.sp
								} else {
									10.sp
								},
								fontFamily = FontFamily.Monospace
							),
							fontWeight = if (selectedItem == index) {
								FontWeight.Bold
							} else {
								FontWeight.Normal
							},
							letterSpacing = 0.sp
						)
					},
					selectedContentColor = Color.Black,
					unselectedContentColor = Color.White

				)

			}

		}

	}
}

private fun back(navController: NavController, route: String) {
	navController.navigate(route) {
		navController.graph.startDestinationRoute?.let { homeScreen ->
			popUpTo(homeScreen) {
				saveState = true
			}
			restoreState = true
			launchSingleTop = true
			navController.popBackStack(
				route,
				inclusive = true
			) // Clear back stack and go to Screen1
		}
	}
}