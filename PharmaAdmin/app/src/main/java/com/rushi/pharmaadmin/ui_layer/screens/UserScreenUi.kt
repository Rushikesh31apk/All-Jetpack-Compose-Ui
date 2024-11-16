package com.rushi.pharmaadmin.ui_layer.screens

import androidx.compose.animation.animateContentSize
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rushi.pharmaadmin.ui.theme.GreenColor
import com.rushi.pharmaadmin.ui_layer.AppViewModel
import com.rushi.pharmaadmin.ui_layer.screens.bottombar.BottomBarNavigation

@Composable
fun UserScreenUi(navController: NavHostController, viewModel: AppViewModel = hiltViewModel()) {

	val getAllUserState = viewModel.getAllUserState.collectAsState()
	val updateUserState = viewModel.updateUserState.collectAsState()
	var searchQuery by remember { mutableStateOf("") }
	var selected by remember { mutableIntStateOf(0) }
	var expandedUserId by remember { mutableStateOf<String?>(null) }

	LaunchedEffect(updateUserState.value.data) {
		viewModel.getAllUsers()
	}

	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.BottomEnd
	) {
		when {
			getAllUserState.value.isLoading -> {
				Column(
					modifier = Modifier
						.fillMaxSize(),
					horizontalAlignment = Alignment.CenterHorizontally,
					verticalArrangement = Arrangement.Center
				) {
					CircularProgressIndicator(modifier = Modifier.size(50.dp))
				}
			}

			getAllUserState.value.error != null -> {
				Column(
					modifier = Modifier
						.fillMaxSize(),
					horizontalAlignment = Alignment.CenterHorizontally,
					verticalArrangement = Arrangement.Center
				) {
					CircularProgressIndicator(modifier = Modifier.size(50.dp))
					Spacer(modifier = Modifier.padding(10.dp))
					Text("Check Your Internet\n\t\tConnection",
						color = Color.Red,
						fontWeight = FontWeight.Bold,
						fontSize = 20.sp,
					)
				}
			}
			else -> {
				updateUserState.value.data?.let {}

				LazyColumn(
					modifier = Modifier
						.fillMaxSize()
						.padding(bottom = 56.dp),  // Leave space for BottomBarNavigation
					horizontalAlignment = Alignment.CenterHorizontally,
					verticalArrangement = Arrangement.spacedBy(8.dp)
				) {
					item {
						Column(
							modifier = Modifier.fillMaxWidth(),
							horizontalAlignment = Alignment.CenterHorizontally
						) {
							TopAppBar(
								title = {
									Box(
										modifier = Modifier.fillMaxWidth() ,
										contentAlignment = Alignment.Center // Makes sure Box takes the full width
									) {
										Column(
											horizontalAlignment = Alignment.CenterHorizontally, // Aligns text in the center
											modifier = Modifier.fillMaxWidth().padding(top = 0.dp)// Ensures it stretches across the width
										) {
											Text(
												text = "ALL USERS",
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
									.clip(RoundedCornerShape(bottomStartPercent = 30, bottomEndPercent = 30, topStartPercent = 0, topEndPercent = 0))
									.fillMaxWidth()// Rounded bottom corners for style

							)
						}
					}

					val filteredData = getAllUserState.value.data.filter {
						it.name.contains(
							searchQuery,
							ignoreCase = true
						)
					}
					items(filteredData ?: emptyList()) { user ->
						var isExpanded = expandedUserId == user.user_id

						Card(
							shape = RoundedCornerShape(10.dp),
							modifier = Modifier
								.fillMaxWidth()
								.padding(horizontal = 8.dp)
								.clickable {
									expandedUserId = if (isExpanded) null else user.user_id
								}
								.animateContentSize(),
							colors = CardDefaults.cardColors(containerColor = Color(0xF8EDC84E))
						) {
							Column {
								// Row showing user's icon, name, and down arrow
								Row(
									modifier = Modifier
										.fillMaxWidth()
										.padding(8.dp),
									horizontalArrangement = Arrangement.SpaceBetween,
									verticalAlignment = Alignment.CenterVertically
								) {
									Row(verticalAlignment = Alignment.CenterVertically) {
										// User Icon
										Icon(
											imageVector = Icons.Default.AccountCircle,
											contentDescription = "User Icon",
											modifier = Modifier.size(40.dp),
											tint = Color.Gray
										)
										Spacer(modifier = Modifier.width(8.dp))
										val formattedName = user.name.split(" ")
											.joinToString(" ") { word -> word.replaceFirstChar { it.uppercase() } }
										Text(
											text = formattedName,
											fontFamily = FontFamily.Serif,
											fontWeight = FontWeight.Bold,
											fontSize = 18.sp,
											color = Color.Black,
											modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
										)
									}

									// Down Arrow Icon to toggle expand
									Icon(
										imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
										contentDescription = "Expand User Info",
										modifier = Modifier.size(34.dp)
									)
								}
								// Expanded information
								if (isExpanded) {
									Column(
										modifier = Modifier
											.fillMaxWidth()
											.padding(horizontal = 12.dp, vertical = 4.dp)
									) {
										Text(
											text = "Phone: ${user.phone_number}",
											fontSize = 14.sp,
											fontWeight = FontWeight.Normal
										)
										Text(
											text = "Email: ${user.email}",
											fontSize = 14.sp,
											fontWeight = FontWeight.Normal
										)
										Text(
											text = "Address: ${user.address}",
											fontSize = 14.sp,
											fontWeight = FontWeight.Normal
										)
										Text(
											text = "Date of Account Creation: ${user.date_of_account_creation}",
											fontSize = 14.sp,
											fontWeight = FontWeight.Normal
										)

										Spacer(modifier = Modifier.height(8.dp))

										Row(
											modifier = Modifier.fillMaxWidth(),
											horizontalArrangement = Arrangement.SpaceBetween,
											verticalAlignment = Alignment.CenterVertically
										) {
											Button(
												onClick = {
													viewModel.updateUser(
														user_id = user.user_id,
														isApproved = if (user.isApproved == 0) 1 else 0
													)},
													colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)), // Green color for Approve
													shape = RoundedCornerShape(12.dp), // Use a rounded rectangular shape
													modifier = Modifier
														.weight(1f)
														.height(48.dp) // Consistent height for the buttons
														.padding(horizontal = 4.dp)
											) {
												Text(text = if (user.isApproved == 0) "Approve" else "Block")
											}

											Button(
												onClick = { /* Delete or other action */ },
												colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)), // Red color for Disapprove
												shape = RoundedCornerShape(12.dp),
												modifier = Modifier
													.weight(1f)
													.height(48.dp)
													.padding(horizontal = 4.dp)
											) {
												Text(text = "Delete")
											}

										}
										Spacer(modifier = Modifier.height(8.dp))
									}

								}
							}
						}
					}
					item {
						Spacer(modifier = Modifier.padding(bottom = 80.dp))
						Text(text = "")
					}
				}
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