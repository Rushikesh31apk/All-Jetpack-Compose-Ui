package com.rushi.pharmaadmin.repository


import com.rushi.pharmaadmin.State
import com.rushi.pharmaadmin.database.ApiProvider
import com.rushi.pharmaadmin.database.resources.AddProductResponce
import com.rushi.pharmaadmin.database.resources.AdminResponce
import com.rushi.pharmaadmin.database.resources.AllUserResponce
import com.rushi.pharmaadmin.database.resources.GetAllOrderResponce
import com.rushi.pharmaadmin.database.resources.GetAllProductResponce
import com.rushi.pharmaadmin.database.resources.UpdateUserResponce
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class Repo {

	suspend fun getAllUsersRepo(): Flow<State<Response<AllUserResponce>>> = flow {
		emit(State.Loading)
		try {
			val response = ApiProvider.provideApi().getAllUsers()
			emit(State.Success(response))
		} catch (e: Exception) {
			emit(State.Error(e.message.toString()))
		}
	}

	suspend fun updateUserRepo(
		user_id: String,
		isApproved: Int
	): Flow<State<Response<UpdateUserResponce>>> = flow {
		emit(State.Loading)
		try {
			val response = ApiProvider.provideApi()
				.updateUserDetails(user_id = user_id, isApproved = isApproved)
			emit(State.Success(response))
		} catch (e: Exception) {
			emit(State.Error(e.message.toString()))
		}
	}

	suspend fun addProductsRepo(
		product_name: String,
		category: String,
		certified:Int,
		price: Int,
		stock: Int,
	): Flow<State<Response<AddProductResponce>>> = flow {
		emit(State.Loading)
		try {
			val response = ApiProvider.provideApi().addProducts(
				product_name = product_name,
				category = category,
				certified = certified,
				price = price,
				stock = stock,
			)
			emit(State.Success(response))
		} catch (e: Exception) {
			emit(State.Error(e.message.toString()))
		}
	}

	suspend fun AdminRepo(
		username: String,
		password: String
	): Flow<State<Response<AdminResponce>>> = flow {
		emit(State.Loading)
		try {
			val response =
				ApiProvider.provideApi().Authtication(username = username, password = password)
			emit(State.Success(response))
		} catch (e: Exception) {
			emit(State.Error(e.message.toString()))
		}
	}

	suspend fun getAllOrdersRepo(): Flow<State<Response<GetAllOrderResponce>>> = flow {
		emit(State.Loading)
		try {
			val response = ApiProvider.provideApi().getAllOrders()
			emit(State.Success(response))
		}catch (e:Exception){
			emit(State.Error(e.message.toString()))
		}
	}

	suspend fun getAllProductsRepo(): Flow<State<Response<GetAllProductResponce>>> = flow{
		emit(State.Loading)
		try {
			val response = ApiProvider.provideApi().getAllProducts()
			emit(State.Success(response))
		}catch (e:Exception){
			emit(State.Error(e.message.toString()))
		}
	}
}