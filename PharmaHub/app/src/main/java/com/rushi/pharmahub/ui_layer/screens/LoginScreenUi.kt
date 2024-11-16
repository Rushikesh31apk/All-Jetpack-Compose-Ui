package com.rushi.pharmahub.ui_layer.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rushi.pharmahub.R
import com.rushi.pharmahub.ui.theme.GreenColor
import com.rushi.pharmahub.ui_layer.AppViewModel
import com.rushi.pharmahub.ui_layer.alertdialog.AwesomeCustomDialog
import com.rushi.pharmahub.ui_layer.alertdialog.AwesomeCustomDialogType
import com.rushi.pharmahub.ui_layer.navigation.RegisterScreen
import com.rushi.pharmahub.ui_layer.resources.SignInSignUp
import com.rushi.pharmahub.ui_layer.resources.TwoColoredText

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun LoginScreenUi(navController: NavHostController, viewModel: AppViewModel = hiltViewModel()) {


	val state = viewModel.signInState.value
	var mail by remember { mutableStateOf("") }
	var password by remember { mutableStateOf("") }
	val successDialog = remember { mutableStateOf(false) }
	val errorDialog = remember { mutableStateOf(false) }
	val infoDialog = remember { mutableStateOf(false) }
	val responseMessage = remember { mutableStateOf("") }
	val isApproveState = viewModel.isApproveState.value

	when {
		state.Loading -> {}
		state.error != null -> {}
		state.data != null -> {
			if (state.data!!.isSuccessful) {
				successDialog.value = true
			} else {
				errorDialog.value = true
			}
		}
	}
	when {
		isApproveState.Loading -> {}
		isApproveState.error != null -> {}

		isApproveState.data != null -> {
			if (isApproveState.data.isSuccessful) {
				responseMessage.value = isApproveState.data.body()?.status.toString() // Assuming status is "0" or "1"
				if (responseMessage.value == "0") {
					AwesomeCustomDialog(
						type = AwesomeCustomDialogType.ERROR,
						title = "Id Not Verified",
						desc = "Please Contact our Admin",
						onDismiss = { successDialog.value = false },
						navController = navController
					)
				} else if (responseMessage.value == "1") {
					if (errorDialog.value) {
						AwesomeCustomDialog(
							type = AwesomeCustomDialogType.ERROR,
							title = "Try Again",
							desc = "username or password is incorrect",
							onDismiss = { errorDialog.value = false },
							navController = navController
						)
					} else {
						if (successDialog.value) {
							AwesomeCustomDialog(
								type = AwesomeCustomDialogType.SUCCESS1,
								title = "Verified Account",
								desc = "Enjoy our Services Go Ahead",
								onDismiss = { successDialog.value = false },
								navController = navController
							)
						}
					}
				}
			}
		}
	}

	if (infoDialog.value) {
		AwesomeCustomDialog(
			type = AwesomeCustomDialogType.INFO,
			title = "Information",
			desc = "All fields are required",
			onDismiss = {
				infoDialog.value = false
			},
			navController = navController
		)
	}
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()
			.background(GreenColor)
	) {
		Box(modifier = Modifier.fillMaxWidth())
		{
			Spacer(modifier = Modifier.padding(top = 60.dp))
			Image(
				painter = painterResource(id = R.drawable.mam),
				contentDescription = null,
				contentScale = ContentScale.Fit,
				modifier = Modifier
					.padding(top = 40.dp)
					.height(220.dp)
					.fillMaxWidth()
			)
		}
		Column(
			modifier = Modifier
				.padding(16.dp)
				.fillMaxWidth()
				.verticalScroll(rememberScrollState()),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {
			Spacer(modifier = Modifier.padding(top = 160.dp))
			SignInSignUp(
				screenName = "Sign In"
			)
			OutlinedTextField(
				value = mail,
				onValueChange = { mail = it },
				shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
				label = {
					Text(
						text = "Mail",
						color = MaterialTheme.colorScheme.scrim,
						style = MaterialTheme.typography.labelMedium,
					)
				},
				singleLine = true,
				modifier = Modifier
					.fillMaxWidth()
					.padding(horizontal = 20.dp),
				leadingIcon = {
					Icon(
						imageVector = Icons.Default.Email,
						contentDescription = null,
						tint = MaterialTheme.colorScheme.primary
					)
				}
			)
			Spacer(modifier = Modifier.padding(vertical = 10.dp))
			OutlinedTextField(
				value = password,
				onValueChange = { password = it },
				shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
				label = {
					Text(
						text = "Password",
						color = MaterialTheme.colorScheme.scrim,
						style = MaterialTheme.typography.labelMedium,
					)
				},
				singleLine = true,
				modifier = Modifier
					.fillMaxWidth()
					.padding(horizontal = 20.dp),
				leadingIcon = {
					Icon(
						imageVector = Icons.Default.Lock,
						contentDescription = null,
						tint = MaterialTheme.colorScheme.primary
					)
				}
			)
			val gradientColor = listOf(Color(0xFF484BF1), Color(0xFF673AB7))
			val cornerRadius = 16.dp
			Spacer(modifier = Modifier.padding(10.dp))
			Button(
				modifier = Modifier
					.fillMaxWidth()
					.padding(start = 30.dp, end = 30.dp),
				onClick = {
					if (mail.isEmpty() || password.isEmpty()) {
						infoDialog.value = true
						return@Button
					}
					viewModel.isApprove(mail)
					viewModel.SignInUser(
						email = mail,
						password = password
					)
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
							brush = Brush.horizontalGradient(colors = gradientColor),
							shape = RoundedCornerShape(topStart = 30.dp, bottomEnd = 30.dp)
						)
						.clip(RoundedCornerShape(topStart = 30.dp, bottomEnd = 30.dp))
						.background(
							brush = Brush.linearGradient(colors = gradientColor),
							shape = RoundedCornerShape(cornerRadius)
						)
						.padding(horizontal = 16.dp, vertical = 8.dp),
					contentAlignment = Alignment.Center
				) {
					Text(
						text = "Login",
						fontSize = 20.sp,
						color = Color.White,
						fontFamily = FontFamily.Serif
					)
				}
			}
			Spacer(modifier = Modifier.padding(5.dp))
			TwoColoredText(
				firstName = "You don't have an account?",
				SecondName = " Sign Up",
				onClick = { navController.navigate(RegisterScreen) }
			)
			Spacer(modifier = Modifier.padding(5.dp))
			ResetPassword()
			Spacer(modifier = Modifier.padding(5.dp))
		}
	}

}


@Composable
fun ResetPassword() {
	TextButton(onClick = {
	}) {
		Text(
			text = "Reset Password",
			letterSpacing = 1.sp,
			style = MaterialTheme.typography.labelLarge,
		)
	}
}

