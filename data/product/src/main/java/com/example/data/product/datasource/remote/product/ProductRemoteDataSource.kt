package com.example.data.product.datasource.remote.product

import com.example.core.networking.model.NetworkError
import com.example.core.networking.model.Res
import com.example.data.product.model.remote.ProductPageResponse

interface ProductRemoteDataSource {

    suspend fun getProductPage(): Res<NetworkError, ProductPageResponse>
    suspend fun getProductPageByCategory(category: String): Res<NetworkError, ProductPageResponse>
    suspend fun getProductPageByName(name: String): Res<NetworkError, ProductPageResponse>
    suspend fun getCategories(): Res<NetworkError, List<String>>
}
