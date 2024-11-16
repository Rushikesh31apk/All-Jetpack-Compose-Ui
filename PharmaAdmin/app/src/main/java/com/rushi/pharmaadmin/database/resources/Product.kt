package com.rushi.pharmaadmin.database.resources

data class Product(
    val category: String,
    val certified: Int,
    val id: Int,
    val price: Int,
    val product_id: String,
    val product_name: String,
    val stock: Int
)