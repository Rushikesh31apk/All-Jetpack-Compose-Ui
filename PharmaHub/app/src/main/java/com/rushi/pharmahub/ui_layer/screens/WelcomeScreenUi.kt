package com.rushi.pharmahub.ui_layer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rushi.pharmahub.R
import com.rushi.pharmahub.ui.theme.GreenColor
import com.rushi.pharmahub.ui_layer.navigation.RegisterScreen
import com.rushi.pharmahub.ui_layer.resources.Buttons
import com.rushi.pharmahub.ui_layer.resources.TwoColoredText

@Composable
fun WelcomeScreenUi(navController: NavHostController) {
	Box(
		modifier = Modifier.fillMaxSize().background(GreenColor)
	) {

		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center,
			modifier = Modifier
				.fillMaxSize()
				.padding(horizontal = 24.dp)
		) {
			Spacer(modifier = Modifier.padding(20.dp))
			Image(
				painter = painterResource(id = R.drawable.login_logo),
				contentDescription = null,
				contentScale = ContentScale.Fit,
				modifier = Modifier.size(300.dp)
			)
			Text(
				text = "Welcome",
				color = Color.White,
				fontWeight = FontWeight.Bold,
				fontSize = 40.sp,
				fontFamily = FontFamily.SansSerif
			)
			Spacer(modifier = Modifier.padding(20.dp))
			Text(
				text = " Your Trusted Partner in Health!",
				fontWeight = FontWeight.Bold,
				fontSize = 20.sp,
			)
			Spacer(modifier = Modifier.padding(20.dp))
			val gradientColor = listOf(Color(0xFF484BF1), Color(0xFF673AB7))
			val cornerRadius = 16.dp
			Buttons(
				gradientColors = gradientColor,
				cornerRadius = cornerRadius,
				nameButton = "Get Started",
				roundedCornerShape = RoundedCornerShape(
					topStart = 30.dp,
					bottomEnd = 30.dp
				),
				navController = navController
			)
			TwoColoredText(
				firstName = "You don't have an account?",
				SecondName = " Sign Up",
				onClick = { navController.navigate(RegisterScreen) }
			)
		}
	}
}