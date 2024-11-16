package com.rushi.pharmahub.ui_layer.resources

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rushi.pharmahub.ui.theme.GreenColor

@Composable
fun TextFieldComponent(
	value: String,
	onValueChange: (String) -> Unit,
	placeholder: String,
	leadingIcon: Int,
) {

	OutlinedTextField(
		value = value,
		onValueChange = onValueChange,
		placeholder = { Text(placeholder) },
		trailingIcon = {
			Icon(
				painter = painterResource(leadingIcon),
				contentDescription = null,
				modifier = Modifier.size(24.dp)
			)
		},
		singleLine = true,
		modifier = Modifier
			.fillMaxWidth()
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