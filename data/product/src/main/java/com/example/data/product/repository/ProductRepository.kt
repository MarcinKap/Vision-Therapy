package com.example.data.product.repository

import com.example.core.networking.model.NetworkError
import com.example.core.networking.model.Res
import com.example.data.product.model.internal.ProductPage

interface ProductRepository {
    suspend fun getProducts(): Res<NetworkError, ProductPage>
    suspend fun getProductsByCategory(category: String): Res<NetworkError, ProductPage>
    suspend fun getProductsByName(name: String): Res<NetworkError, ProductPage>
    suspend fun getCategories(): Res<NetworkError, List<String>>
}
