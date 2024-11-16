package com.rushi.pharmaadmin.ui_layer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rushi.pharmaadmin.State
import com.rushi.pharmaadmin.State.*
import com.rushi.pharmaadmin.database.resources.AddProductResponce
import com.rushi.pharmaadmin.database.resources.AdminResponce
import com.rushi.pharmaadmin.database.resources.AllUserResponceItem
import com.rushi.pharmaadmin.database.resources.GetAllOrderResponce
import com.rushi.pharmaadmin.database.resources.GetAllProductResponce
import com.rushi.pharmaadmin.database.resources.UpdateUserResponce
import com.rushi.pharmaadmin.repository.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repo: Repo) : ViewModel() {
	private val _getAllUserState = MutableStateFlow(GetAllUserState())
	val getAllUserState = _getAllUserState.asStateFlow()

	private val _updateUserState = MutableStateFlow(UpdateUserState())
	val updateUserState = _updateUserState.asStateFlow()

	private val _addProductState = MutableStateFlow(AddProductState())
	val addProductState = _addProductState.asStateFlow()

	private val _adminState = MutableStateFlow(AdminState())
	val adminState = _adminState.asStateFlow()

	private val _getAllOrderState = MutableStateFlow(GetAllOrderState())
	val getAllOrderState = _getAllOrderState.asStateFlow()

	private val _getAllProductState = MutableStateFlow(GetAllProductState())
	val getAllProductState = _getAllProductState.asStateFlow()

	fun Admin(username: String, password: String) {
		viewModelScope.launch {
			repo.AdminRepo(
				username = username,
				password = password
			).collect { state ->
				when (state) {
					is State.Loading -> {
						_adminState.value = AdminState(Loading = true)
					}
					is State.Success -> {
						_adminState.value = AdminState(data = state.data, Loading = false)
					}
					is State.Error -> {
						_adminState.value = AdminState(error = state.message, Loading = false)
					}
				}
			}
		}
	}

	fun getAllUsers() {
		viewModelScope.launch(Dispatchers.IO) {
			repo.getAllUsersRepo().collect {
				when (it) {
					is Success -> {
						_getAllUserState.value = GetAllUserState(data = it.data.body()!!)
					}

					is Error -> {
						_getAllUserState.value = GetAllUserState(error = it.message)
					}

					is Loading -> {
						_getAllUserState.value = GetAllUserState(isLoading = true)
					}
				}
			}
		}
	}


	fun getAllOrder(){
		viewModelScope.launch(Dispatchers.IO) {
			repo.getAllOrdersRepo().collect{
				when(it) {
					is Loading -> {
						_getAllOrderState.value = GetAllOrderState(Loading = true)
					}

					is Success -> {
						_getAllOrderState.value = GetAllOrderState(data = it.data,Loading = false)
					}

					is Error -> {
						_getAllOrderState.value = GetAllOrderState(error = it.message,Loading = false)
					}
				}
			}
		}
	}

	fun updateUser(user_id: String, isApproved: Int) {
		viewModelScope.launch(Dispatchers.IO) {
			repo.updateUserRepo(
				user_id = user_id,
				isApproved = isApproved
			).collect {
				when (it) {
					is Loading -> {
						_updateUserState.value = UpdateUserState(Loading = true)
					}

					is Success -> {
						_updateUserState.value =
							UpdateUserState(data = it.data, Loading = false)
					}

					is Error -> {
						_updateUserState.value = UpdateUserState(error = it.message)
					}
				}
			}
		}
	}


	fun addProducts(
		product_name: String,
		category: String,
		certified: Int,
		price: Int,
		stock: Int,
	) {
		viewModelScope.launch {
			repo.addProductsRepo(
				product_name = product_name,
				category = category,
				certified = certified,
				price = price,
				stock = stock,
			).collect {
				when (it) {
					is Loading -> {
						_addProductState.value = AddProductState(Loading = true)
					}

					is Success -> {
						_addProductState.value =
							AddProductState(data = it.data, Loading = false)
					}

					is Error -> {
						_addProductState.value =
							AddProductState(error = it.message, Loading = false)
					}
				}
			}
		}
	}

	fun getAllProducts(){
		viewModelScope.launch(Dispatchers.IO) {
			repo.getAllProductsRepo().collect{
				when(it) {
					is Loading -> {
						_getAllProductState.value = GetAllProductState(Loading = true)
					}
					is Success -> {
						_getAllProductState.value = GetAllProductState(data = it.data,Loading = false)
					}
					is Error -> {
						_getAllProductState.value = GetAllProductState(error = it.message,Loading = false)
					}
				}
			}
		}
	}

}

data class AddProductState(
	val Loading: Boolean = false,
	val error: String? = null,
	val data: Response<AddProductResponce>? = null
)

data class GetAllUserState(
	val isLoading: Boolean = false,
	val error: String? = null,
	val data: List<AllUserResponceItem> = emptyList()
)

data class UpdateUserState(
	val Loading: Boolean = false,
	val error: String? = null,
	val data: Response<UpdateUserResponce>? = null
)

data class AdminState(
	val Loading: Boolean = false,
	val error: String? = null,
	val data: Response<AdminResponce>? = null
)

data class GetAllOrderState(
	val Loading: Boolean = false,
	val error: String? = null,
	val data: Response<GetAllOrderResponce>?=null
)

data class GetAllProductState(
	val Loading: Boolean = false,
	val error: String? = null,
	val data: Response<GetAllProductResponce>?=null
)