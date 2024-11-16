package com.rushi.pharmaadmin.database.resources

data class GetAllOrderResponceItem(
    val category: String,
    val date_of_order_creation: String,
    val id: Int,
    val isApproved: Int,
    val message: String,
    val order_id: String,
    val price: Int,
    val product_id: String,
    val product_name: String,
    val quantity: Int,
    val total_amount: Int,
    val user_id: String,
    val user_name: String
)