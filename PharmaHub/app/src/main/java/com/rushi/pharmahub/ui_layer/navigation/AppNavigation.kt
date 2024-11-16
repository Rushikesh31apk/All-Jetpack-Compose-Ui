package com.rushi.pharmahub.ui_layer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rushi.pharmahub.ui_layer.screens.LoginScreenUi
import com.rushi.pharmahub.ui_layer.screens.RegisterScreenUi
import com.rushi.pharmahub.ui_layer.screens.WelcomeScreenUi
import com.rushi.pharmahub.ui_layer.screens.dashboardscreen.DashBoardUi
import com.rushi.pharmahub.ui_layer.screens.dashboardscreen.HomeScreenUi
import com.rushi.pharmahub.ui_layer.screens.dashboardscreen.OrderScreenUi
import com.rushi.pharmahub.ui_layer.screens.dashboardscreen.StockHistoryUi
import com.rushi.pharmahub.ui_layer.screens.dashboardscreen.UserProfileUi

@Composable
fun AppNavigation(){

	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = WelcomeScreen) {
		composable<WelcomeScreen> {
			WelcomeScreenUi(navController = navController)
		}
		composable<LoginScreen> {
			LoginScreenUi(navController= navController)
		}
		composable<RegisterScreen> {
			RegisterScreenUi(navController= navController)
		}
		composable<HomeScreen> {
			HomeScreenUi(navController= navController)
		}
		composable<DashboardScreen> {
			DashBoardUi(navController)
		}
		composable<ProfileScreen> {
			UserProfileUi(navController)
		}
		composable<OrderScreen> {
			OrderScreenUi(navController)
		}
		composable<HistoryScreen> {
			StockHistoryUi(navController)
		}

	}
}