package com.rushi.pharmahub.ui_layer.resources

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rushi.pharmahub.ui.theme.AlegreyaFontFamily
import com.rushi.pharmahub.ui_layer.navigation.LoginScreen

@Composable
fun Buttons(
	gradientColors: List<Color>,
	cornerRadius: Dp,
	nameButton: String,
	roundedCornerShape: RoundedCornerShape,
	navController: NavHostController
) {
	Button(
		modifier = Modifier
			.fillMaxWidth()
			.padding(start = 30.dp, end = 30.dp),
		onClick = {
			navController.navigate(LoginScreen)
		},
		contentPadding = PaddingValues(),
		colors = ButtonDefaults.buttonColors(
			containerColor = Color.Transparent
		),
		shape = RoundedCornerShape(cornerRadius)
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.background(
					brush = Brush.horizontalGradient(colors = gradientColors),
					shape = roundedCornerShape
				)
				.clip(roundedCornerShape)
				.background(
					brush = Brush.linearGradient(colors = gradientColors),
					shape = RoundedCornerShape(cornerRadius)
				)
				.padding(horizontal = 16.dp, vertical = 8.dp),
			contentAlignment = Alignment.Center
		) {
			Text(
				text = nameButton,
				fontSize = 20.sp,
				color = Color.White,
				fontFamily = FontFamily.Serif
			)
		}
	}
}


@Composable
fun TwoColoredText(
	firstName: String,
	SecondName: String,
	onClick: () -> Unit
) {
	Row {
		TextButton(onClick = {
			onClick.invoke()
		}) {
			Text(
				text = firstName,
				letterSpacing = 1.sp,
				style = MaterialTheme.typography.labelLarge,
				fontFamily = AlegreyaFontFamily,
				fontSize = 14.sp
			)
			Text(text=SecondName,
				letterSpacing = 1.sp,
				style = MaterialTheme.typography.labelMedium,
				color = Color.Red,
				fontFamily = AlegreyaFontFamily,
				fontSize = 14.sp
			)
		}
	}
}



@Composable
fun SignInSignUp(
	screenName:String
) {
	Text(
		text = screenName,
		textAlign = TextAlign.Center,
		modifier = Modifier
			.padding(top = 110.dp)
			.fillMaxWidth(),
		style = MaterialTheme.typography.headlineLarge,
		fontWeight = FontWeight.Bold,
		fontFamily = FontFamily.Serif,
		color = MaterialTheme.colorScheme.primary,
	)
}