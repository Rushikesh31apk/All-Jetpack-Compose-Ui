package com.rushi.pharmahub.repository

import com.rushi.pharmahub.data_layer.ApiProvider
import com.rushi.pharmahub.data_layer.responce.SignInResponce
import com.rushi.pharmahub.data_layer.responce.SignUpResponce
import com.rushi.pharmahub.data_layer.responce.isApproveResponce
import com.rushi.pharmahub.ui_layer.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class Repo {

	suspend fun SignUpUser(
		name: String,
		password: String,
		email: String,
		phone_number: String,
		address: String,
		pinCode: String
	): Flow<State<Response<SignUpResponce>>> = flow {
		emit(State.Loading)
		try {
			val response = ApiProvider.ProvideApi().SignUpUser(
				name = name,
				password = password,
				email = email,
				phone_number = phone_number,
				address = address,
				pinCode = pinCode
			)
			emit(State.Success(response))
		} catch (e: Exception) {
			emit(State.Error(e.message.toString()))
		}

	}

	suspend fun SignInUser(
		email: String,
		password: String
	): Flow<State<Response<SignInResponce>>> =
		flow {
			emit(State.Loading)
			try {
				val response =
					ApiProvider.ProvideApi().SignInUser(email = email, password = password)
				emit(State.Success(response))
			} catch (e: Exception) {
				emit(State.Error(e.message.toString()))
			}
		}

	suspend fun isApproveRepo(email: String): Flow<State<Response<isApproveResponce>>> = flow {
		emit(State.Loading)
		try {
			val response = ApiProvider.ProvideApi().isApprove(email=email)
			emit(State.Success(response))
		} catch (e: Exception) {
			emit(State.Error(e.message.toString()))
		}
	}

}