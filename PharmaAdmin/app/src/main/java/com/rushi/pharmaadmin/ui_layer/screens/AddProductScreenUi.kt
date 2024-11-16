package com.rushi.pharmaadmin.ui_layer.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rushi.pharmaadmin.R
import com.rushi.pharmaadmin.ui_layer.AppViewModel
import com.rushi.pharmaadmin.ui_layer.navigation.Products
import com.rushi.pharmaadmin.ui_layer.navigation.UserScreen
import com.rushi.pharmaadmin.ui_layer.screens.bottombar.BottomBarNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreenUi(
	navController: NavHostController,
	viewModel: AppViewModel = hiltViewModel()
) {

	val addProductState = viewModel.addProductState.collectAsState()
	var productName by remember { mutableStateOf("") }
	var stock by remember { mutableStateOf("") }
	var price by remember { mutableStateOf("") }
	var category by remember { mutableStateOf("") }
	var isCertified by remember { mutableStateOf(0) }
	var selected by remember { mutableIntStateOf(1) }
	val context = LocalContext.current
	when {
		addProductState.value.Loading -> {}

		addProductState.value.error != null -> {
			Column(
				modifier = Modifier.fillMaxSize(),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				CircularProgressIndicator(
					modifier = Modifier.size(50.dp),
					color = Color(0xFF58B0F4)
				)
				Spacer(modifier = Modifier.height(16.dp))
				Text(
					text = "Check Your Internet\n\t\tConnection",
					fontSize = 20.sp,
					fontWeight = FontWeight.Bold,
					fontFamily = FontFamily.Serif
				)
			}
		}

		addProductState.value.data != null -> {
			if (addProductState.value.data!!.isSuccessful) {
				Toast.makeText(
					context,
					"Product Added Successfully",
					Toast.LENGTH_SHORT
				).show()
				productName = ""
				stock = ""
				price = ""
				category = ""
				isCertified = 0

			} else {
				Toast.makeText(
					context,
					"Something went wrong",
					Toast.LENGTH_SHORT
				).show()
			}
		}
	}


	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.BottomEnd
	) {

		LazyColumn(
			modifier = Modifier
				.fillMaxSize(),
			verticalArrangement = Arrangement.Top,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			item {
				Box(
					modifier = Modifier
						.fillMaxWidth()
						.padding(start = 10.dp, top = 20.dp),
					contentAlignment = Alignment.TopStart
				) {
					Row(
						horizontalArrangement = Arrangement.Start
					) {
						Icon(
							imageVector = Icons.Default.KeyboardArrowLeft,
							contentDescription = "Back",
							modifier = Modifier
								.size(40.dp)
								.clickable { navController.navigate(Products) }
						)
					}

				}
			}
			item {
				Box(
					modifier = Modifier
						.fillMaxWidth().padding(20.dp),
					contentAlignment = Alignment.TopCenter
				) {
					Image(
						painter = painterResource(R.drawable.add_product),
						contentDescription = null,
						contentScale = ContentScale.Crop,
						modifier = Modifier.size(130.dp)
					)
				}
			}
			item {
				Text(
					text = "Add Product",
					fontSize = 34.sp,
					fontWeight = FontWeight.Bold,
					modifier = Modifier.padding(bottom = 16.dp)
				)
			}
			item {
				OutlinedTextField(
					value = productName,
					onValueChange = { productName = it },
					label = { Text("Product Name") },
					leadingIcon = {
						Icon(
							imageVector = Icons.Default.ShoppingCart,
							contentDescription = "Product Icon",
							tint = Color(0xFF060505)
						)
					},
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 25.dp),
					singleLine = true,
					keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
					colors = TextFieldDefaults.outlinedTextFieldColors(
						focusedBorderColor = Color(0xFF5AF903),   // Border color when focused
						unfocusedBorderColor = Color(0xFF060505),
						unfocusedLabelColor = Color(0xFF060505), // Label color when not focused
						focusedLabelColor = Color(0xFF060505)// Border color when not focused
					)
				)
			}
			item {
				Spacer(modifier = Modifier.height(12.dp))
				OutlinedTextField(
					value = stock,
					onValueChange = { stock = it },
					label = { Text("Stock") },
					leadingIcon = {
						Icon(
							painter = painterResource(id = R.drawable.ic_stock),
							contentDescription = "Product Icon",
							tint = Color(0xFF060505)
						)
					},
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 25.dp),
					singleLine = true,
					keyboardOptions = KeyboardOptions(
						keyboardType = KeyboardType.Number,
						imeAction = ImeAction.Next
					),
					colors = TextFieldDefaults.outlinedTextFieldColors(
						focusedBorderColor = Color(0xFF5AF903),   // Border color when focused
						unfocusedBorderColor = Color(0xFF060505),
						unfocusedLabelColor = Color(0xFF060505), // Label color when not focused
						focusedLabelColor = Color(0xFF060505)// Border color when not focused
					)
				)
			}
			item {
				Spacer(modifier = Modifier.height(12.dp))
				OutlinedTextField(
					value = price,
					onValueChange = { price = it },
					label = { Text("Price") },
					leadingIcon = {
						Icon(
							painter = painterResource(id = R.drawable.ic_price),
							contentDescription = "Product Icon",
							tint = Color(0xFF060505)
						)
					},
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 25.dp),
					singleLine = true,
					keyboardOptions = KeyboardOptions(
						keyboardType = KeyboardType.Decimal,
						imeAction = ImeAction.Next
					),
					colors = TextFieldDefaults.outlinedTextFieldColors(
						focusedBorderColor = Color(0xFF5AF903),   // Border color when focused
						unfocusedBorderColor = Color(0xFF060505),  // Border color when not focused // Label color when focused
						unfocusedLabelColor = Color(0xFF060505), // Label color when not focused
						focusedLabelColor = Color(0xFF060505)
					)
				)
			}
			item {
				Spacer(modifier = Modifier.height(12.dp))
				OutlinedTextField(
					value = category,
					onValueChange = { category = it },
					label = { Text("Category") },
					leadingIcon = {
						Icon(
							painter = painterResource(id = R.drawable.ic_category),
							contentDescription = "Product Icon",
							tint = Color(0xFF060505)
						)
					},
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 25.dp),
					singleLine = true,
					keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
					colors = TextFieldDefaults.outlinedTextFieldColors(
						focusedBorderColor = Color(0xFF5AF903),   // Border color when focused
						unfocusedBorderColor = Color(0xFF060505),
						unfocusedLabelColor = Color(0xFF060505), // Label color when not focused
						focusedLabelColor = Color(0xFF060505)// Border color when not focused
					)
				)
			}
			item {
				Row(
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.End
				) {
					Checkbox(
						checked = if (isCertified == 1) true else false,
						onCheckedChange = {
							if (isCertified == 1) isCertified = 0 else isCertified = 1
						},
						colors = CheckboxDefaults.colors(
							checkedColor = Color(0xFF4CAF50), // Green color for checked state
							uncheckedColor = Color(0xFF060505) // Gray color for unchecked state
						),
					)
					Spacer(modifier = Modifier.width(2.dp))
					Text(
						text = "Certified",
						style = MaterialTheme.typography.bodyMedium.copy( // Text color
							fontWeight = FontWeight.Bold,
							fontSize = 16.sp,
							letterSpacing = 0.5.sp,
							lineHeight = 24.sp,
							fontFamily = FontFamily.Serif
						),
						modifier = Modifier.padding(end = 25.dp)
					)
				}
			}
			item {
				Button(
					onClick = {
						if (productName.isEmpty() || stock.isEmpty() || price.isEmpty() || category.isEmpty()) {
							Toast.makeText(
								context,
								"Please fill all the fields",
								Toast.LENGTH_SHORT
							).show()
							return@Button
						}
						viewModel.addProducts(
							product_name = productName,
							category = category,
							certified = isCertified,
							price = price.toInt(),
							stock = stock.toInt(),
						)
					},
					modifier = Modifier
						.fillMaxWidth()
						.height(50.dp)
						.padding(horizontal = 25.dp),
					shape = RoundedCornerShape(10.dp),
					colors = ButtonDefaults.buttonColors(
						containerColor = Color(0xFF58B0F4)
					)
				) {
					Text(
						text = "Add Product",
						color = Color.White,
						fontSize = 20.sp,
						fontFamily = FontFamily.Monospace,
						fontWeight = FontWeight.Bold
					)
				}
			}
			item {
				Spacer(modifier = Modifier.padding(bottom = 80.dp))
				Text(text = "Powered By Rushikesh")
			}

		}
		Box(
			modifier = Modifier.fillMaxWidth(),
			contentAlignment = Alignment.BottomEnd
		) {
			BottomBarNavigation(
				navHostController = navController,
				selectedItem = selected,
				onSelectedItem = {
					selected = it
				}
			)
		}
	}
}

