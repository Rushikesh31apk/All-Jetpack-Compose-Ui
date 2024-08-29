package com.rushi.jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.rushi.jetpackcompose.Data.getBlogList
import com.rushi.jetpackcompose.Layout.BlogListScreen
import com.rushi.jetpackcompose.Layout.LazyRowScrollableComponent
import com.rushi.jetpackcompose.Layout.ScrollableColumnComponent
import com.rushi.jetpackcompose.Layout.ScrollableRowComponent
import com.rushi.jetpackcompose.MaterialDesign.BottomNavigationWithLabelComponent
import com.rushi.jetpackcompose.MaterialDesign.BottomNavigationWithoutLabelComponent
import com.rushi.jetpackcompose.MaterialDesign.HomeScreen
import com.rushi.jetpackcompose.MaterialDesign.SimpleScaffoldComponent
import com.rushi.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
	@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			JetpackComposeTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding->
					//SimpleButtonComponent()
					//CardExample(modifier = Modifier.padding(innerPadding))
					//ClickableExample(modifier = Modifier.padding(innerPadding))
					//CustomView(modifier = Modifier.padding(innerPadding))
					//AlertDialogEX()
					//singleChoiceDialog()
					//imageex()
					//SimpleBoxComponent()
					//SimpleColumnComponent()
					Column(modifier = Modifier.padding(innerPadding)) {
						//BlogListScreen()
						//LazyRowScrollableComponent(blogList =getBlogList() )
						//ScrollableColumnComponent(blogList = getBlogList())
						//ScrollableRowComponent(blogList = getBlogList())
						//SimpleScaffoldComponent()
						//HomeScreen()
						//BottomNavigationWithoutLabelComponent()
						BottomNavigationWithLabelComponent()
					}

				}
			}
		}
	}
}
