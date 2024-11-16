package com.rushi.pharmaadmin.database

import com.rushi.pharmaadmin.database.resources.AddProductResponce
import com.rushi.pharmaadmin.database.resources.AdminResponce
import com.rushi.pharmaadmin.database.resources.AllUserResponce
import com.rushi.pharmaadmin.database.resources.GetAllOrderResponce
import com.rushi.pharmaadmin.database.resources.GetAllProductResponce
import com.rushi.pharmaadmin.database.resources.UpdateUserResponce
import okhttp3.internal.connection.RealCall
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST


interface ApiService {

	@FormUrlEncoded
	@POST("validateAdmin")
	suspend fun Authtication(
		@Field("username") username: String,
		@Field("password") password: String
	): Response<AdminResponce>

	@GET("getAllUsers")
	suspend fun getAllUsers(): Response<AllUserResponce>

	@FormUrlEncoded
	@PATCH("updateUserAllDetails")
	suspend fun updateUserDetails(
		@Field("user_id") user_id: String,
		@Field("isApproved") isApproved: Int
	):Response<UpdateUserResponce>

	@FormUrlEncoded
	@POST("addProducts")
	suspend fun addProducts(
		@Field("product_name") product_name:String,
		@Field("category") category:String,
		@Field("certified") certified: Int,
		@Field("price") price: Int,
		@Field("stock") stock:Int,
	):Response<AddProductResponce>

	@GET("getAllProducts")
	suspend fun getAllProducts():Response<GetAllProductResponce>

	@GET("getAllOrdersDetail")
	suspend fun getAllOrders():Response<GetAllOrderResponce>

}