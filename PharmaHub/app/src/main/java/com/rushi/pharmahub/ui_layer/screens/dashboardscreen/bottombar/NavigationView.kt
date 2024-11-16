package com.rushi.pharmahub.ui_layer.screens.dashboardscreen.bottombar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.rushi.pharmahub.R
import com.rushi.pharmahub.ui.theme.GreenColor
import com.rushi.pharmahub.ui.theme.LightGreenColor
import com.rushi.pharmahub.ui_layer.navigation.DashboardScreen
import com.rushi.pharmahub.ui_layer.navigation.HistoryScreen
import com.rushi.pharmahub.ui_layer.navigation.HomeScreen
import com.rushi.pharmahub.ui_layer.navigation.OrderScreen
import com.rushi.pharmahub.ui_layer.navigation.ProfileScreen
import com.rushi.pharmahub.ui_layer.navigation.WelcomeScreen

@Composable
fun NavigationView(
	navController: NavHostController,
	selectedItem: Int,
	onSelectedItem: (index: Int) -> Unit
) {

	val items = listOf("Home", "Dashboard","Orders","History", "Profile")
	Box(
		modifier = Modifier.fillMaxWidth()
	) {
		BottomNavigation(
			modifier = Modifier
				.size(500.dp,78.dp)
				.fillMaxWidth()
				.padding(bottom = 0.dp, start = 0.dp, end = 0.dp)
				.clip(RoundedCornerShape(bottomStartPercent = 0, bottomEndPercent = 0, topStartPercent = 50, topEndPercent = 50)),
			backgroundColor = GreenColor
		) {
			items.forEachIndexed { index, s ->
				val tint = if (selectedItem == index) {
					Color.White
				} else {
					Color.Black
				}
				BottomNavigationItem(
					selected = selectedItem == index,
					onClick = {
						onSelectedItem(index)
						when (index) {
							0 -> {
								navController.navigate(HomeScreen) {
									navController.popBackStack()
								}
							}

							1 -> {
								navController.navigate(DashboardScreen) {
									navController.popBackStack()
								}
							}

							2 -> {
								navController.navigate(OrderScreen) {
									navController.popBackStack()
								}
							}

							3 -> {
								navController.navigate(HistoryScreen) {
									navController.popBackStack()
								}
							}
							4 -> {
								navController.navigate(ProfileScreen) {
									navController.popBackStack()
								}
							}
						}
					},
					icon = {
						when (index) {
							0 -> {
								Icon(
									Icons.Outlined.Home,
									contentDescription = null,
									tint = tint,
									modifier = Modifier.padding(top = 10.dp).size(
										if (selectedItem == index) {
											50.dp
										} else {
											40.dp
										}
									)
								)
							}

							1 -> {
								Icon(
									Icons.Outlined.Email,
									contentDescription = null,
									tint = tint,
									modifier = Modifier.padding(top = 15.dp).size(
										if (selectedItem == index) {
											50.dp
										} else {
											34.dp
										}
									)
								)
							}

							2 -> {
								Icon(
									painter = painterResource(R.drawable.shopping_bag),
									contentDescription = null,
									tint = tint,
									modifier = Modifier.padding(top = 15.dp).size(
										if (selectedItem == index) {
											50.dp
										} else {
											34.dp
										}
									)
								)
							}

							3 -> {
								Icon(
									Icons.Default.Notifications,
									contentDescription = null,
									tint =tint ,
									modifier = Modifier.padding(top = 15.dp).size(
										if (selectedItem == index) {
											40.dp
										} else {
											30.dp
										}
									)
								)
							}
							4 -> {
								Icon(
									Icons.Outlined.Person,
									contentDescription = null,
									tint =tint ,
									modifier = Modifier.padding(top = 15.dp).size(
										if (selectedItem == index) {
											50.dp
										} else {
											34.dp
										}
									)
								)
							}
						}
					}, label = {
						Text(
							text = items[index], style = TextStyle(
								color = tint,
								fontSize = if (selectedItem == index) {
									12.sp
								} else {
									10.sp
								},
								fontFamily = FontFamily(Font(R.font.alegreya_bold)),
								fontWeight = if (selectedItem == index) {
									androidx.compose.ui.text.font.FontWeight.Bold
								} else {
									androidx.compose.ui.text.font.FontWeight.Normal
								},
								letterSpacing = 0.sp
							)
						)
					},
					selectedContentColor = LightGreenColor,
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