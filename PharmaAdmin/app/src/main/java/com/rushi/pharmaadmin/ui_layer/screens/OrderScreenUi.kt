package com.rushi.pharmaadmin.ui_layer.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rushi.pharmaadmin.database.resources.GetAllOrderResponceItem
import com.rushi.pharmaadmin.ui.theme.GreenColor
import com.rushi.pharmaadmin.ui_layer.AppViewModel
import com.rushi.pharmaadmin.ui_layer.screens.bottombar.BottomBarNavigation


@Composable
fun OrderScreenUi(navController: NavHostController, viewModel: AppViewModel = hiltViewModel()) {
	val orderState = viewModel.getAllOrderState.collectAsState().value
	var selected by remember { mutableIntStateOf(2) }
	var searchQuery by remember { mutableStateOf("") }

	LaunchedEffect(Unit) {
		viewModel.getAllOrder()
	}

	Column(
		modifier = Modifier.fillMaxSize(),
	) {
		TopAppBar(
			title = {
				Box(
					modifier = Modifier.fillMaxWidth() // Makes sure Box takes the full width
				) {
					Column(
						horizontalAlignment = Alignment.CenterHorizontally, // Aligns text in the center
						modifier = Modifier.fillMaxWidth() // Ensures it stretches across the width
					) {
						Text(
							text = "ORDERS",
							color = Color.White,
							fontWeight = FontWeight.Bold,
							fontSize = 25.sp,
							fontFamily = FontFamily.Serif
						)
						Spacer(modifier = Modifier.height(5.dp))

						OutlinedTextField(
							value = searchQuery,
							onValueChange = {searchQuery = it},
							placeholder = { Text(text = "search by username") },
							trailingIcon = {
								Icon(
									imageVector = Icons.Default.Search,
									contentDescription = "Search",
									tint = Color.Red
								)
							},
							singleLine = true,
							modifier = Modifier
								.fillMaxWidth()
								.padding(horizontal = 20.dp)
								.background(shape = RoundedCornerShape(16.dp), color = Color.White),
							shape = RoundedCornerShape(16.dp),
							colors = OutlinedTextFieldDefaults.colors(
								focusedBorderColor = GreenColor,
								unfocusedBorderColor = Color.LightGray,
								focusedTextColor = Color.Black,
								unfocusedTextColor = Color.Gray,
								focusedLabelColor = GreenColor,
								unfocusedLabelColor = Color.LightGray,
								cursorColor = GreenColor
							)

						)
					}
				}
			},
			backgroundColor = Color(0xD718F721), // Custom Green background
			modifier = Modifier
				.height(130.dp) // Increases top bar height for a more spacious look
				.clip(RoundedCornerShape(bottomStartPercent = 30, bottomEndPercent = 30)) // Rounded bottom corners for style
				.shadow(10.dp) // Adds shadow to enhance the floating effect
		)




		Box(
			modifier = Modifier
				.fillMaxSize()
				.background(Color.White),
			contentAlignment = Alignment.BottomEnd
		) {
			when {
				orderState.Loading -> {
					Box(
						modifier = Modifier.fillMaxSize(),
						contentAlignment = Alignment.Center
					) {
						CircularProgressIndicator()
					}
				}
				orderState.error != null -> {
					Text(
						text = orderState.error,
						color = Color.Red,
						modifier = Modifier.align(Alignment.Center)
					)
				}
				orderState.data != null -> {
					val orders = orderState.data.body()?.filter {
						it.user_name.contains(searchQuery, ignoreCase = true)
					} ?: emptyList()

					LazyColumn(
						modifier = Modifier.fillMaxSize(),
						horizontalAlignment = Alignment.CenterHorizontally,
						verticalArrangement = Arrangement.Top
					) {
						items(orders) { order ->
							ExpandableOrderItem(order = order)
						}
						item {
							Spacer(modifier = Modifier.padding(bottom = 80.dp))
							Text(text = "")
						}
					}
				}
			}

			BottomBarNavigation(
				navHostController = navController,
				selectedItem = selected,
				onSelectedItem = { selected = it }
			)
		}
	}
}

@Composable
fun ExpandableOrderItem(order: GetAllOrderResponceItem) {
	var isExpanded by remember { mutableStateOf(false) }

	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(8.dp),
		shape = RoundedCornerShape(8.dp),
		elevation = CardDefaults.elevatedCardElevation(8.dp) // Shadow effect for elevation
	) {
		Column(
			modifier = Modifier
				.background(Color(0xFF5EBFEA))
				.clickable { isExpanded = !isExpanded }
				.padding(16.dp)
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(verticalAlignment = Alignment.CenterVertically) {
					Icon(
						imageVector = Icons.Default.AccountCircle,
						contentDescription = "User Icon",
						tint = Color.Black ,// Color for the icon
						modifier = Modifier.size(50.dp)
					)
					Spacer(modifier = Modifier.width(8.dp))
					val formattedName = order.user_name.split(" ")
						.joinToString(" ") { word -> word.replaceFirstChar { it.uppercase() } }
					Text(
						text = formattedName,
						fontFamily = FontFamily.Serif,
						fontWeight = FontWeight.Bold,
						fontSize = 20.sp,
						color = Color.White,
						modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
					)
				}
				IconButton(onClick = { isExpanded = !isExpanded }) {
					Icon(
						imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
						contentDescription = "Expand",
						modifier = Modifier.size(30.dp)
					)
				}
			}

			AnimatedVisibility(visible = isExpanded) {
				Column(
					modifier = Modifier
						.fillMaxWidth()
						.padding(top = 8.dp)
				) {
					Text(text = "Product Name: ${order.product_name}")
					Text(text = "Quantity: ${order.quantity}")
					Text(text = "Price: ${order.price}")
					Text(text = "Total Amount: ${order.total_amount}")
					Text(text = "Order Date: ${order.date_of_order_creation}")
					Text(text = "Category: ${order.category}")

					Spacer(modifier = Modifier.height(8.dp))

					Row(
						modifier = Modifier
							.fillMaxWidth()
							.padding(8.dp), // Optional padding for spacing around the row
						horizontalArrangement = Arrangement.SpaceEvenly
					) {
						Button(
							onClick = { /* Approve action */ },
							colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)), // Green color for Approve
							shape = RoundedCornerShape(12.dp), // Use a rounded rectangular shape
							modifier = Modifier
								.weight(1f)
								.height(48.dp) // Consistent height for the buttons
								.padding(horizontal = 4.dp)
						) {
							Text("Approve", color = Color.White)
						}

						Button(
							onClick = { /* Disapprove action */ },
							colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)), // Red color for Disapprove
							shape = RoundedCornerShape(12.dp),
							modifier = Modifier
								.weight(1f)
								.height(48.dp)
								.padding(horizontal = 4.dp)
						) {
							Text("Disapprove", color = Color.White)
						}
					}

				}
			}
		}
	}
}

