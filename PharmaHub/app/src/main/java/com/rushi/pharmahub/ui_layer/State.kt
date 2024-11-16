package com.rushi.pharmahub.ui_layer


sealed class State<out T> {
	object Loading: State<Nothing>()
	data class Success<T>(val data: T) : State<T>()
	data class Error<Nothing>(val message: String) : State<Nothing>()
}