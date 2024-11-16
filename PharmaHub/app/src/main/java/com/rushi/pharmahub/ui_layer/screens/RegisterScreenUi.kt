package com.rushi.pharmahub.ui_layer.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rushi.pharmahub.R
import com.rushi.pharmahub.ui.theme.GreenColor
import com.rushi.pharmahub.ui_layer.AppViewModel
import com.rushi.pharmahub.ui_layer.alertdialog.AwesomeCustomDialog
import com.rushi.pharmahub.ui_layer.alertdialog.AwesomeCustomDialogType
import com.rushi.pharmahub.ui_layer.alertdialog.component.InfoDialog
import com.rushi.pharmahub.ui_layer.navigation.LoginScreen
import com.rushi.pharmahub.ui_layer.resources.TwoColoredText

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun RegisterScreenUi(navController: NavHostController, viewModel: AppViewModel = hiltViewModel()) {

	val state = viewModel.signUpState.value
	val context = LocalContext.current
	val successDialog = remember { mutableStateOf(false) }
	val errorDialog = remember { mutableStateOf(false) }
	val infoDialog = remember { mutableStateOf(false) }

	when {
		state.Loading -> {}
		state.error != null -> {
			errorDialog.value=true
		}
		state.data != null -> {
			if (state.data.isSuccessful) {
				successDialog.value = true
			} else {
			}
		}
	}

	if (successDialog.value) {
		AwesomeCustomDialog(
			type = AwesomeCustomDialogType.SUCCESS,
			title = "Success",
			desc = "Approval Request Send",
			onDismiss = {
				successDialog.value = false
			},
			navController = navController
		)
	}
	if (errorDialog.value) {
		AwesomeCustomDialog(
			type = AwesomeCustomDialogType.ERROR,
			title = "Something Went Wrong",
			desc = "Please Try Again",
			onDismiss = {
				errorDialog.value = false
			},
			navController=navController
		)
	}


	var name by remember { mutableStateOf("") }
	var password by remember { mutableStateOf("") }
	var email by remember { mutableStateOf("") }
	var address by remember { mutableStateOf("") }
	var phone_number by remember { mutableStateOf("") }
	var pinCode by remember { mutableStateOf("") }

	Box(
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()
			.background(GreenColor)
	) {
		Box(modifier = Modifier.align(Alignment.Center))
		{
			Column(
				modifier = Modifier
					.padding(16.dp)
					.fillMaxWidth()
					.verticalScroll(rememberScrollState()),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Spacer(modifier = Modifier.height(50.dp))
				Image(
					painter = painterResource(id = R.drawable.mam),
					contentDescription = null,
					contentScale = ContentScale.Fit,
					modifier = Modifier
						.fillMaxWidth()
						.size(220.dp)

				)
				SignUpText()
				Spacer(modifier = Modifier.height(20.dp))
				OutlinedTextField(
					value = name,
					onValueChange = {
						name = it
					},
					shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
					label = {
						Text(
							"Enter Your Name",
							color = MaterialTheme.colorScheme.primary,
							style = MaterialTheme.typography.labelMedium,
						)
					},
					singleLine = true,
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 20.dp),
					leadingIcon = {
						Icon(
							imageVector = Icons.Default.Person,
							contentDescription = null,
							tint = MaterialTheme.colorScheme.primary
						)
					}
				)
				Spacer(modifier = Modifier.padding(vertical = 10.dp))
				OutlinedTextField(
					value = email,
					onValueChange = { email = it },
					shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
					label = {
						Text(
							"Enter Your Email",
							color = MaterialTheme.colorScheme.primary,
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
							"Enter Your Password",
							color = MaterialTheme.colorScheme.primary,
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
				Spacer(modifier = Modifier.padding(vertical = 10.dp))
				OutlinedTextField(
					value = address,
					onValueChange = { address = it },
					shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
					label = {
						Text(
							"Enter Your Address",
							color = MaterialTheme.colorScheme.primary,
							style = MaterialTheme.typography.labelMedium,
						)
					},
					singleLine = true,
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 20.dp),
					leadingIcon = {
						Icon(
							imageVector = Icons.Default.Home,
							contentDescription = null,
							tint = MaterialTheme.colorScheme.primary
						)
					}
				)
				Spacer(modifier = Modifier.padding(vertical = 10.dp))
				OutlinedTextField(
					value = phone_number,
					onValueChange = { phone_number = it },
					shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
					label = {
						Text(
							"Enter Your Phone Number",
							color = MaterialTheme.colorScheme.primary,
							style = MaterialTheme.typography.labelMedium,
						)
					},
					singleLine = true,
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 20.dp),
					leadingIcon = {
						Icon(
							imageVector = Icons.Default.Call,
							contentDescription = null,
							tint = MaterialTheme.colorScheme.primary
						)
					}
				)
				Spacer(modifier = Modifier.padding(vertical = 10.dp))
				OutlinedTextField(
					value = pinCode,
					onValueChange = { pinCode = it },
					shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
					label = {
						Text(
							"Enter Your Pin Code",
							color = MaterialTheme.colorScheme.primary,
							style = MaterialTheme.typography.labelMedium,
						)
					},
					singleLine = true,
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 20.dp),
					leadingIcon = {
						Icon(
							imageVector = Icons.Default.LocationOn,
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
						if (name.isEmpty() || password.isEmpty() || email.isEmpty() || address.isEmpty() || phone_number.isEmpty() || pinCode.isEmpty()) {
							infoDialog.value=true
							return@Button
						}
						viewModel.SignUpUser(
							name = name,
							password = password,
							email = email,
							address = address,
							phone_number = phone_number,
							pinCode = pinCode
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
							text = "Register",
							fontSize = 20.sp,
							color = Color.White,
							fontFamily = FontFamily.Serif
						)
					}
				}
				Spacer(modifier = Modifier.padding(5.dp))
				TwoColoredText(
					firstName = "You have an account?",
					SecondName = " Login",
					onClick = { navController.navigate(LoginScreen) }
				)
				Spacer(modifier = Modifier.padding(25.dp))
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
			navController=navController
		)
	}
}


@Composable
fun SignUpText() {
	Text(
		text = "Sign Up",
		textAlign = TextAlign.Center,
		modifier = Modifier
			.padding(top = 30.dp)
			.fillMaxWidth(),
		style = MaterialTheme.typography.headlineLarge,
		fontWeight = FontWeight.Bold,
		fontFamily = FontFamily.Serif,
		color = MaterialTheme.colorScheme.primary,
	)
}

@Composable
fun MyAlertDialog(
	shouldShowDialog: MutableState<Boolean>,
	navController: NavHostController,
	viewModel: AppViewModel
) {

	if (shouldShowDialog.value) { // 2
		AlertDialog( // 3
			onDismissRequest = { // 4
				shouldShowDialog.value = false
			},
			// 5
			icon = {
				Icon(
					imageVector = Icons.Default.CheckCircle,
					contentDescription = null,
					tint = MaterialTheme.colorScheme.primary,
					modifier = Modifier.size(55.dp)
				)
			},
			containerColor = Color(0xFFEFB8C8),
			title = {
				Text(
					text = "Account Approval Request Send Successfully",
					color = Color.Black,
					fontWeight = FontWeight.Bold,
					textAlign = TextAlign.Center,
				)
			},
			confirmButton = { // 6
				Button(
					onClick = {
						shouldShowDialog.value = false
					},
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 50.dp),
					shape = RoundedCornerShape(15.dp),
					colors = ButtonDefaults.buttonColors(
						containerColor = MaterialTheme.colorScheme.primary,
						contentColor = Color.White
					)
				) {
					Text(
						text = "Please Login",
						color = Color.White
					)
				}
			}
		)
	}
}




