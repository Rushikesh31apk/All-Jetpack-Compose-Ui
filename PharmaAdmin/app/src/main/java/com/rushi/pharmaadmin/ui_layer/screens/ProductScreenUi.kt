package com.rushi.pharmaadmin.ui_layer.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rushi.pharmaadmin.R
import com.rushi.pharmaadmin.database.resources.GetAllOrderResponceItem
import com.rushi.pharmaadmin.database.resources.GetAllProductResponce
import com.rushi.pharmaadmin.database.resources.Product
import com.rushi.pharmaadmin.ui.theme.GreenColor
import com.rushi.pharmaadmin.ui_layer.AppViewModel
import com.rushi.pharmaadmin.ui_layer.navigation.AddProduct
import com.rushi.pharmaadmin.ui_layer.screens.bottombar.BottomBarNavigation

@Composable
fun ProductScreenUi(navController: NavHostController, viewModel: AppViewModel = hiltViewModel()) {
	val productState = viewModel.getAllProductState.collectAsState().value
	var selected by remember { mutableIntStateOf(1) }
	var searchQuery by remember { mutableStateOf("") }

	// Load all products when this screen is launched
	LaunchedEffect(Unit) {
		viewModel.getAllProducts()
	}

	Column(modifier = Modifier.fillMaxSize()) {
		TopAppBar(
			title = {
				Box(modifier = Modifier.fillMaxWidth()) {
					Column(
						horizontalAlignment = Alignment.CenterHorizontally,
						modifier = Modifier.fillMaxWidth()
					) {
						Text(
							text = "All Products",
							color = Color.White,
							fontWeight = FontWeight.Bold,
							fontSize = 25.sp,
							fontFamily = FontFamily.Serif
						)
						Spacer(modifier = Modifier.height(5.dp))

						// Search bar with placeholder and trailing search icon
						OutlinedTextField(
							value = searchQuery,
							onValueChange = { searchQuery = it },
							placeholder = { Text(text = "Search products") },
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
								cursorColor = GreenColor
							)
						)
					}
				}
			},
			backgroundColor = Color(0xD718F721),
			modifier = Modifier
				.height(130.dp)
				.clip(RoundedCornerShape(bottomStartPercent = 30, bottomEndPercent = 30))
				.shadow(10.dp)
		)

		// Main content area with loading, error, or product list
		Box(
			modifier = Modifier
				.fillMaxSize()
				.background(Color.White),
			contentAlignment = Alignment.BottomEnd
		) {
			when {
				productState.Loading -> {
					Box(
						modifier = Modifier.fillMaxSize(),
						contentAlignment = Alignment.Center
					) {
						CircularProgressIndicator()
					}
				}

				productState.error != null -> {
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

				productState.data != null -> {
					// Filter products by search query
					val filteredProducts = productState.data.body()?.products?.filter {
						it.product_name.contains(searchQuery, ignoreCase = true)
					} ?: emptyList()

					LazyColumn(
						modifier = Modifier.fillMaxSize(),
						horizontalAlignment = Alignment.CenterHorizontally,
						verticalArrangement = Arrangement.Top
					) {
						items(filteredProducts) { product ->
							ExpandableProductItem(product = product)
						}
						item {
							Spacer(modifier = Modifier.padding(bottom = 80.dp))
							Text(text = "")
						}
					}
				}
			}
			FloatingActionButton(
				onClick = { navController.navigate(AddProduct) },
				modifier = Modifier
					.padding(end = 16.dp, bottom = 72.dp),  // Position above the BottomBar
				containerColor = Color(0xFF85ED85) // Customize color if needed
			) {
				Icon(
					imageVector = Icons.Default.Add,  // Use the "Add" icon for adding a user
					contentDescription = "Add User",
					tint = Color.White  // Customize icon color if needed
				)
			}

			// Bottom Navigation Bar
			BottomBarNavigation(
				navHostController = navController,
				selectedItem = selected,
				onSelectedItem = { selected = it }
			)
		}
	}
}


@Composable
fun ExpandableProductItem(product: Product) {
	var isExpanded by remember { mutableStateOf(false) }

	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(8.dp)
			.animateContentSize(),
		shape = RoundedCornerShape(8.dp),
		colors = CardDefaults.cardColors(containerColor = Color(0xFF8FFF4E)),

		elevation = CardDefaults.elevatedCardElevation(8.dp)
	) {
		Column(
			modifier = Modifier
				.background(Color(0xFF5EBFEA))
				.clickable { isExpanded = !isExpanded }
				.padding(16.dp)
		) {
			// Row showing product icon, name, and expand icon
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(verticalAlignment = Alignment.CenterVertically) {
					Image(
						painter = painterResource(id = R.drawable.add_product),
						contentDescription = "Product Icon",
						modifier = Modifier.size(40.dp)
					)
					Spacer(modifier = Modifier.width(8.dp))
					Text(
						text = product.product_name.replaceFirstChar { it.uppercase() },
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

			// Expanded details
			AnimatedVisibility(visible = isExpanded) {
				Column(
					modifier = Modifier
						.fillMaxWidth()
						.padding(top = 8.dp)
				) {
					Text(text = "Product Name: ${product.product_name}")
					Text(text = "Price: ${product.price}")
					Text(text = "Stock: ${product.stock}")
					Text(text = "Category: ${product.category}")

					Spacer(modifier = Modifier.height(8.dp))

					Button(
						onClick = { /* Edit action */ },
						colors = ButtonDefaults.buttonColors(containerColor = GreenColor), // Blue color for Edit
						shape = RoundedCornerShape(12.dp),
						modifier = Modifier
							.fillMaxWidth()
							.height(48.dp)
							.padding(horizontal = 4.dp)
					) {
						Text("Edit", color = Color.White)
					}
				}
			}
		}
	}
}