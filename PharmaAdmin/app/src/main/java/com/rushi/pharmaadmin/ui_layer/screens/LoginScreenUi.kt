package com.rushi.pharmaadmin.ui_layer.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rushi.pharmaadmin.R
import com.rushi.pharmaadmin.ui_layer.AppViewModel
import com.rushi.pharmaadmin.ui_layer.navigation.UserScreen

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenUi(navController: NavController, viewModel: AppViewModel = hiltViewModel()) {

	val context = LocalContext.current
	val state = viewModel.adminState.collectAsState().value
	var userName by remember { mutableStateOf("") }
	var userPassword by remember { mutableStateOf("") }
	var passwordVisible by remember { mutableStateOf(false) }
	var isError1 by remember { mutableStateOf(false) }  // Error state variable
	var toastShown by remember { mutableStateOf(false) }  // Flag to prevent toast from showing twice

	when {
		state.Loading -> {
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(Color.Transparent),
				contentAlignment = Alignment.Center
			) {
				CircularProgressIndicator(
					modifier = Modifier
						.size(40.dp)
						.background(Color.Transparent),
					color = Color.Black,
					strokeWidth = 5.dp
				)
			}
		}

		state.error != null -> {}
		state.data != null -> {
			if (state.data.isSuccessful == true) {
				Toast.makeText(
					context,
					"Login Successfully",
					Toast.LENGTH_SHORT
				).show()
				navController.popBackStack()
				navController.navigate(UserScreen)
			} else {
				if (!toastShown) {
					Toast.makeText(context, "username or password is incorrect", Toast.LENGTH_SHORT)
						.show()
					toastShown = true // Set flag to true after showing toast
				}
				isError1 = true
			}
		}

	}


	Box(modifier = Modifier
		.fillMaxSize()
		.background(Color.Transparent)) {
		Image(
			painter = painterResource(id = R.drawable.loginback),
			contentDescription = null,
			contentScale = ContentScale.Crop,
			modifier = Modifier
				.fillMaxSize()
				.graphicsLayer {
					alpha = 0.5f // Slightly reduce the image brightness
				},
		)
	}
	LazyColumn(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Top,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		item {
			// Column to arrange UI elements vertically
			Column(
				modifier = Modifier
					.fillMaxHeight().padding(40.dp),
				verticalArrangement = Arrangement.Top,
				horizontalAlignment = Alignment.CenterHorizontally
			) {

				Image(
					painter = painterResource(id = R.drawable.admin_logo),
					contentDescription = null,
					contentScale = ContentScale.Fit,
					modifier = Modifier
						.fillMaxWidth()
						.size(180.dp)

				)
				Text(
					text = "Hello,\nWelcome to the PharmaHub",
					fontSize = 13.sp,
					color = Color.Blue,
					fontWeight = FontWeight.Bold,
					modifier = Modifier
						.fillMaxWidth()
						.padding(0.dp, 50.dp, 0.dp, 0.dp)
				)

				// Username input field
				OutlinedTextField(
					value = userName,
					onValueChange = {
						userName = it
					},
					leadingIcon = {
						Icon(Icons.Default.Person, contentDescription = "person")
					},

					label = {
						Text(text = "Admin")
					},
					modifier = Modifier
						.fillMaxWidth()
						.padding(0.dp, 20.dp, 0.dp, 0.dp),
					colors = TextFieldDefaults.outlinedTextFieldColors(
						focusedBorderColor = if (isError1) Color.Red else Color(0xFFF9F9F9),
						unfocusedBorderColor = if (isError1) Color.Red else Color(0xF70B0A0A),
						unfocusedLabelColor = Color(0xFF060505),
						focusedLabelColor = Color(0xFF0A0909)
					)
				)

				// Password input field
				OutlinedTextField(
					value = userPassword,
					onValueChange = {
						userPassword = it
					},
					leadingIcon = {
						Icon(Icons.Default.Lock, contentDescription = "password")
					},
					label = {
						Text(text = "password")
					},
					modifier = Modifier
						.fillMaxWidth()
						.padding(0.dp, 20.dp, 0.dp, 0.dp),
					visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
					trailingIcon = {
						val image =
							if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
						IconButton(onClick = { passwordVisible = !passwordVisible }) {
							Icon(
								imageVector = image,
								contentDescription = if (passwordVisible) "Hide password" else "Show password"
							)
						}
					},
					colors = TextFieldDefaults.outlinedTextFieldColors(
						focusedBorderColor = if (isError1) Color.Red else Color(0xFFF8F8F7),
						unfocusedBorderColor = if (isError1) Color.Red else Color(0xF70B0A0A),
						unfocusedLabelColor = Color(0xFF060505),
						focusedLabelColor = Color(0xFF070707)
					)
				)

				// Login button
				Button(
					onClick = {
						if (userName.isEmpty() || userPassword.isEmpty()) {
							Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
							return@Button
						}
						viewModel.Admin(
							username = userName,
							password = userPassword
						)
						toastShown=false
					},
					modifier = Modifier
						.fillMaxWidth()
						.padding(0.dp, 35.dp, 0.dp, 0.dp),
					shape = RoundedCornerShape(10),
					colors = ButtonDefaults.outlinedButtonColors(
						contentColor = Color(0xFF050606),
						containerColor = Color(0xFF2DF106),
						disabledContentColor = Color(0xFFEE2E07),
						disabledContainerColor = Color(0xFFEE2E07)
					)
				) {
					Text(
						text = "Login",
						modifier = Modifier
							.fillMaxWidth(),
						textAlign = TextAlign.Center,
						fontSize = 20.sp
					)
				}
			}

		}

	}


}
