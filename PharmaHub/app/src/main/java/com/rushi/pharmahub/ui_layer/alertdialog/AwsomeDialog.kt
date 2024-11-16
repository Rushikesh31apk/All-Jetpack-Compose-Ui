package com.rushi.pharmahub.ui_layer.alertdialog

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.rushi.pharmahub.ui_layer.alertdialog.component.ErrorDialog
import com.rushi.pharmahub.ui_layer.alertdialog.component.InfoDialog
import com.rushi.pharmahub.ui_layer.alertdialog.component.SuccessDialog
import com.rushi.pharmahub.ui_layer.alertdialog.component.SuccessDialog1

@Composable
fun AwesomeCustomDialog(
	type: AwesomeCustomDialogType,
	title: String,
	desc: String,
	onDismiss: () -> Unit,
	navController: NavHostController
) {
	MaterialTheme {
		when (type) {
			AwesomeCustomDialogType.SUCCESS -> {
				SuccessDialog(
					title = title,
					desc = desc,
					onDismiss = onDismiss,
					navController = navController
				)
			}
			AwesomeCustomDialogType.ERROR -> {
				ErrorDialog(
					title = title,
					desc = desc,
					onDismiss = onDismiss,
					navController = navController
				)
			}
			AwesomeCustomDialogType.INFO -> {
				InfoDialog(
					title = title,
					desc = desc,
					onDismiss = onDismiss
				)
			}
			AwesomeCustomDialogType.SUCCESS1 -> {
				SuccessDialog1(
					title = title,
					desc = desc,
					onDismiss = onDismiss,
					navController = navController
				)
			}
		}
	}
}


enum class AwesomeCustomDialogType {
	SUCCESS, ERROR, INFO,SUCCESS1
}
