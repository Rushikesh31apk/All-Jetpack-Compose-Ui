package com.rushi.pharmaadmin.database.resources

data class GetAllProductResponce(
    val products: List<Product>,
    val status: Int
)