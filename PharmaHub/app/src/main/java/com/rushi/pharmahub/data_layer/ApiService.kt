package com.rushi.pharmahub.data_layer

import com.rushi.pharmahub.data_layer.responce.SignInResponce
import com.rushi.pharmahub.data_layer.responce.SignUpResponce
import com.rushi.pharmahub.data_layer.responce.isApproveResponce
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface ApiService{

	@FormUrlEncoded
	@POST("signUp")
	suspend fun SignUpUser(
		@Field("name") name: String,
		@Field("password") password: String,
		@Field("email") email: String,
		@Field("phone_number") phone_number: String,
		@Field("address") address: String,
		@Field("pinCode") pinCode: String
	):Response<SignUpResponce>

	@FormUrlEncoded
	@POST("login")
	suspend fun SignInUser(
		@Field("email") email: String,
		@Field("password") password: String
	):Response<SignInResponce>

	@FormUrlEncoded
	@POST("check_disapproval")
	suspend fun isApprove(
		@Field("email") email: String
	):Response<isApproveResponce>

}