package com.woigt.applicationworkapi.api


import com.woigt.applicationworkapi.model.Product
import retrofit2.http.GET

interface ProductApi {

    @GET("getdata.php")
    fun getProductApi(): retrofit2.Call<List<Product>>
}