package com.rushi.pharmahub.ui_layer.screens.dashboardscreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rushi.medicalapp.ui_layer.screens.clientChoiceList
import com.rushi.pharmahub.R
import com.rushi.pharmahub.ui.theme.GreenColor
import com.rushi.pharmahub.ui.theme.LightGreenColor
import com.rushi.pharmahub.ui_layer.resources.CategoryItem
import com.rushi.pharmahub.ui_layer.resources.ClientItemView
import com.rushi.pharmahub.ui_layer.screens.dashboardscreen.bottombar.NavigationView
import com.rushi.pharmahub.ui_layer.resources.PagerSlider
import com.rushi.pharmahub.ui_layer.resources.TextFieldComponent
import com.rushi.pharmahub.ui_layer.resources.dataclass.categoryList

@Composable
fun HomeScreenUi(navController: NavHostController) {

	var selectedItem by remember { mutableIntStateOf(0) }
	val context = LocalContext.current

	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.BottomEnd
	) {
		LazyColumn(
			modifier = Modifier
				.fillMaxSize()
				.background(Color.White),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Top
		) {
			item {
				Box(
					modifier = Modifier
						.fillMaxSize()
						.background(Color.White)
				) {
					HomeTopBar()
				}
			}
			item {
				Column(
					modifier = Modifier
						.fillMaxSize()
						.padding(start =  8.dp, end = 8.dp, top = 8.dp, bottom = 70.dp),
					horizontalAlignment = Alignment.CenterHorizontally,
					verticalArrangement = Arrangement.Center
				) {
					Spacer(Modifier.height(8.dp))
					PagerSlider()
					Spacer(Modifier.height(8.dp))

					Row(
						modifier = Modifier.fillMaxWidth(),
						horizontalArrangement = Arrangement.SpaceBetween,
						verticalAlignment = Alignment.CenterVertically
					) {
						Text(
							text = "Categories", style = TextStyle(
								color = Color.Black,
								fontSize = 16.sp,
								fontWeight = FontWeight.Medium,
								fontFamily = FontFamily(Font(R.font.alegreya_semibold))
							)
						)
						Box(
							modifier = Modifier
								.padding(end = 8.dp)
								.shadow(shape = CircleShape, elevation = 1.dp)
								.background(LightGreenColor)
								.padding(4.dp),
							contentAlignment = Alignment.Center
						) {
							Text(
								text = "see more", style = TextStyle(
									color = Color.Black,
									fontSize = 14.sp,
									fontWeight = FontWeight.Medium,
									fontFamily = FontFamily(Font(R.font.alegreya_bold))
								)
							)
						}
					}
					Spacer(Modifier.height(8.dp))
					LazyRow(
						modifier = Modifier.fillMaxWidth()
					) {
						items(categoryList) {
							CategoryItem(
								itemName = it.itemName,
								itemImage = it.itemImage
							)
						}
					}
					Spacer(Modifier.height(8.dp))
					Row(
						modifier = Modifier.fillMaxWidth(),
						horizontalArrangement = Arrangement.SpaceBetween,
						verticalAlignment = Alignment.CenterVertically
					) {
						Text(
							text = "Client's Choice", style = TextStyle(
								color = Color.Black,
								fontSize = 16.sp,
								fontWeight = FontWeight.Medium,
								fontFamily = FontFamily(Font(R.font.alegreyasans_regular))
							)
						)
						Box(
							modifier = Modifier
								.padding(end = 8.dp)
								.shadow(shape = CircleShape, elevation = 1.dp)
								.background(LightGreenColor)
								.padding(4.dp),
							contentAlignment = Alignment.Center
						) {
							Text(
								text = "see more", style = TextStyle(
									color = GreenColor,
									fontSize = 12.sp,
									fontWeight = FontWeight.Medium,
									fontFamily = FontFamily(Font(R.font.alegreya_semibold))
								)
							)
						}
					}
					Spacer(Modifier.height(8.dp))

					LazyRow(
						modifier = Modifier.fillMaxWidth()
					) {
						items(clientChoiceList) {
							ClientItemView(
								itemImage = it.itemImage,
								price = it.price,
								rating = it.rating,
								itemName = it.itemName
							)
						}
					}
					Spacer(Modifier.height(8.dp))
					Row(
						modifier = Modifier.fillMaxWidth(),
						horizontalArrangement = Arrangement.SpaceBetween,
						verticalAlignment = Alignment.CenterVertically
					) {
						Text(
							text = "Promotion", style = TextStyle(
								color = Color.Black,
								fontSize = 16.sp,
								fontWeight = FontWeight.Medium,
								fontFamily = FontFamily(Font(R.font.alegreya_bold))
							)
						)
						Box(
							modifier = Modifier
								.padding(end = 8.dp)
								.shadow(shape = CircleShape, elevation = 1.dp)
								.background(LightGreenColor)
								.padding(4.dp),
							contentAlignment = Alignment.Center
						) {
							Text(
								text = "see more", style = TextStyle(
									color = Color.Black,
									fontSize = 12.sp,
									fontWeight = FontWeight.Medium,
									fontFamily = FontFamily(Font(R.font.alegreyasans_medium))
								)
							)
						}
					}
					LazyRow(
						modifier = Modifier.fillMaxWidth()
					) {
						items(clientChoiceList) {
							ClientItemView(
								itemImage = it.itemImage,
								price = it.price,
								rating = it.rating,
								itemName = it.itemName
							)
						}
					}


				}
			}
		}

		Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
			NavigationView(
				navController,
				selectedItem = selectedItem,
				onSelectedItem = {
					selectedItem = it
					Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
				}
			)
		}

	}

}

@Composable
fun HomeTopBar() {

	var searchText by remember { mutableStateOf("") }
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.background(
				GreenColor,
				shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
			)
	) {

		Column(
			modifier = Modifier
				.padding(start = 16.dp,end = 16.dp, bottom = 16.dp)
				.fillMaxWidth()
				.background(GreenColor)
				.padding(8.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Text(
					text = "Welcome Rushikesh", style = TextStyle(
						color = Color.White,
						fontSize = 16.sp,
						fontWeight = FontWeight.Bold,
						fontFamily = FontFamily(Font(R.font.alegreya_bold))
					)
				)
				Icon(
					imageVector = Icons.Default.Notifications,
					contentDescription = null,
					tint = Color.Red
				)
			}
			Spacer(Modifier.height(8.dp))

			TextFieldComponent(
				value = searchText,
				onValueChange = {
					searchText = it
				},
				placeholder = "Search medicine",
				leadingIcon = R.drawable.search,

			)
		}
	}
}