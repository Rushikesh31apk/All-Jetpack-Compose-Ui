package com.rushi.jetpackcompose.Dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import java.util.*


// The state should be at the lower most common parent of the
// composables, which are going to interact.
val dialogState by lazy { mutableStateOf(false) }
val selectedCountry by lazy { mutableStateOf("") }

val countriesList = getCountries().values.toList()

@Composable
fun singleChoiceDialog(){
	Column(
		modifier = Modifier.fillMaxSize().padding(top=100.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		CountriesDialog()
		SingleChoiceDialogActivityContent()
	}

}


@Composable
fun SingleChoiceDialogActivityContent() {
	Column {
		Button(
			onClick = {
				dialogState.value = true
			},
			modifier = Modifier.padding(16.dp).fillMaxWidth(),
			shape = RoundedCornerShape(8.dp),
			colors = ButtonDefaults.buttonColors(Color.Black)
		) {
			Text(
				text = "Show Countries List",
				textAlign = TextAlign.Center,
				color = Color.White
			)
		}
		Divider(color = Color.Black)
		Text(
			text = selectedCountry.value,
			textAlign = TextAlign.Center,
			color = Color.Black
		)
	}
}

@Composable
fun CountriesDialog() {
	SingleSelectDialog(
		dialogState = dialogState,
		title = "Choose your Country",
		optionsList = countriesList,
		submitButtonText = "Select",
		onSubmitButtonClick = { selectedCountry.value = countriesList[it] },
		onDismissRequest = { dialogState.value = false }
	)
}

// Generally it's a good habit that we create 2 composables, one which accepts
// state and one which maintain its own state. That way,
// the developer has more control ,which approach he/she wants to follow.
@Composable
fun SingleSelectDialog(
	dialogState: MutableState<Boolean>,
	title: String,
	optionsList: List<String>,
	defaultSelected: Int = -1,
	submitButtonText: String,
	onSubmitButtonClick: (Int) -> Unit,
	onDismissRequest: () -> Unit
) {
	if (dialogState.value) {
		SingleSelectDialog(
			title = title,
			optionsList = optionsList,
			defaultSelected = defaultSelected,
			submitButtonText = submitButtonText,
			onSubmitButtonClick = onSubmitButtonClick,
			onDismissRequest = onDismissRequest
		)
	}
}
@Composable
fun SingleSelectDialog(
	title: String,
	optionsList: List<String>,
	defaultSelected: Int = -1,
	submitButtonText: String,
	onSubmitButtonClick: (Int) -> Unit,
	onDismissRequest: () -> Unit
) {
	// Remember the selected option state
	val selectedOption = remember { mutableStateOf(defaultSelected) }

	Dialog(onDismissRequest = onDismissRequest) {
		Surface(
			modifier = Modifier.fillMaxWidth(),
			shape = RoundedCornerShape(10.dp)
		) {
			Column(modifier = Modifier.padding(10.dp)) {
				Text(text = title, style = MaterialTheme.typography.headlineMedium)
				Spacer(modifier = Modifier.height(10.dp))

				LazyColumn(
					modifier = Modifier
						.fillMaxHeight()
						.padding(end = 16.dp)
				) {
					items(optionsList) { option ->
						val isSelected = optionsList.indexOf(option) == selectedOption.value

						Row(
							modifier = Modifier
								.fillMaxWidth()
								.clickable {
									selectedOption.value = optionsList.indexOf(option)
								}
								.padding(vertical = 8.dp)
						) {
							RadioButton(
								selected = isSelected,
								onClick = {
									selectedOption.value = optionsList.indexOf(option)
								}
							)
							Text(
								text = option,
								modifier = Modifier
									.padding(start = 16.dp)
									.align(Alignment.CenterVertically)
							)
						}
					}
				}

				Spacer(modifier = Modifier.height(10.dp))

				Button(
					onClick = {
						onSubmitButtonClick(selectedOption.value)
						onDismissRequest()
					},
					shape = MaterialTheme.shapes.medium
				) {
					Text(text = submitButtonText)
				}
			}
		}
	}
}



@Composable
fun CustomRadioButton(text: String, selectedValue: String, onClickListener: (String) -> Unit) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.selectable(
				selected = (text == selectedValue),
				onClick = { onClickListener(text) }
			)
			.padding(horizontal = 16.dp)
	) {
		RadioButton(
			selected = (text == selectedValue),
			onClick = { onClickListener(text) }
		)
		Text(
			text = text,
			style = MaterialTheme.typography.bodyLarge,
			modifier = Modifier.padding(start = 16.dp).clickable { false }
		)
	}
}


// Dummy Util function for the sake of example
fun getCountries(): Map<String, String> {
	val countriesMap = hashMapOf<String, String>()
	val isoCountries = Locale.getISOCountries()
	isoCountries.forEach {
		val locale = Locale("", it)
		countriesMap[locale.country.toLowerCase(Locale.getDefault())] = locale.displayCountry
	}
	return countriesMap.toList().sortedBy { (_, value) -> value }.toMap()
}