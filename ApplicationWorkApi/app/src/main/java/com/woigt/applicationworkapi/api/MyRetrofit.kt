package com.woigt.applicationworkapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MyRetrofit {

    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun productApi(): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }

    companion object {
        private const val  BASE_URL =
            "https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/mycart/"

        private var myRetrofit: MyRetrofit? = null

        @get:Synchronized
        val instance: MyRetrofit?
            get() {
                if (myRetrofit == null) {
                    myRetrofit = MyRetrofit()
                }
                return myRetrofit
            }
    }

}