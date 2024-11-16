package com.rushi.pharmaadmin.ui_layer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rushi.pharmaadmin.ui_layer.screens.AddProductScreenUi
import com.rushi.pharmaadmin.ui_layer.screens.DashboardScreenUi
import com.rushi.pharmaadmin.ui_layer.screens.LoginScreenUi
import com.rushi.pharmaadmin.ui_layer.screens.OrderScreenUi
import com.rushi.pharmaadmin.ui_layer.screens.ProductScreenUi
import com.rushi.pharmaadmin.ui_layer.screens.UserScreenUi

@Composable
fun AppNavigation() {

	val navController = rememberNavController()
	NavHost(navController = navController, startDestination =LoginScreen) {

		composable<LoginScreen> {
			LoginScreenUi(navController)
		}
		composable<UserScreen> {
			UserScreenUi(navController)
		}
		composable<Products> {
			ProductScreenUi(navController)
		}
		composable<AddProduct> {
			AddProductScreenUi(navController)
		}
		composable<Orders> {
			OrderScreenUi(navController)
		}
		composable<Dashboard> {
			DashboardScreenUi(navController)
		}
	}
}