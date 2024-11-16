package com.rushi.pharmahub.ui_layer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rushi.pharmahub.data_layer.responce.SignInResponce
import com.rushi.pharmahub.data_layer.responce.SignUpResponce
import com.rushi.pharmahub.data_layer.responce.isApproveResponce
import com.rushi.pharmahub.repository.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repo: Repo) : ViewModel() {

	private val _signUpState = mutableStateOf(SignUpState())
	val signUpState = _signUpState

	private val _signInState = mutableStateOf(SignInState())
	val signInState = _signInState

	private val _isApproveState = mutableStateOf(isApproveStates())
	val isApproveState = _isApproveState



	fun SignUpUser(
		name: String,
		password: String,
		email: String,
		phone_number: String,
		address: String,
		pinCode: String
	) {
		viewModelScope.launch(Dispatchers.IO) {
			repo.SignUpUser(
				name = name,
				password = password,
				email = email,
				phone_number = phone_number,
				address = address,
				pinCode = pinCode
			).collect {
				when (it) {
					is State.Loading -> {
						_signUpState.value = SignUpState(Loading = true)
					}

					is State.Success -> {
						_signUpState.value = SignUpState(data = it.data, Loading = false)
					}

					is State.Error -> {
						_signUpState.value = SignUpState(error = it.message)
					}
				}

			}
		}
	}

	fun SignInUser(email: String, password: String) {
		viewModelScope.launch(Dispatchers.IO) {
			repo.SignInUser(
				email = email,
				password = password
			).collect {
				when (it) {
					is State.Loading -> {
						_signInState.value = SignInState(Loading = true)
					}

					is State.Success -> {
						_signInState.value = SignInState(data = it.data, Loading = false)
					}

					is State.Error -> {
						_signInState.value = SignInState(error = it.message)
					}
				}
			}
		}
	}

	fun isApprove(email: String) {
		viewModelScope.launch(Dispatchers.IO) {
			repo.isApproveRepo(
				email = email
			).collect {
				when (it) {
					is State.Loading -> {
						_isApproveState.value = isApproveStates(Loading = true)
					}

					is State.Success -> {
						_isApproveState.value = isApproveStates(data = it.data, Loading = false)
					}

					is State.Error -> {
						_isApproveState.value= isApproveStates(error = it.message, Loading = false)
					}
				}
			}
		}

	}
}


data class SignUpState(
	val Loading: Boolean = false,
	val error: String? = null,
	val data: Response<SignUpResponce>? = null
)

data class SignInState(
	val Loading: Boolean = false,
	val error: String? = null,
	val data: Response<SignInResponce>? = null
)

data class isApproveStates(
	val Loading: Boolean = false,
	val error: String? = null,
	val data: Response<isApproveResponce>? = null
)





