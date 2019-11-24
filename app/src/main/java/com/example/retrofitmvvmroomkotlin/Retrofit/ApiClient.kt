package com.example.retrofitmvvmroomkotlin.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class ApiClient {
     object apiClient {
        fun getApiClient(): Retrofit? {
            val BASE_URL = "https://reqres.in/api/"
            var okHttpClient = OkHttpClient.Builder().build();
            var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .callFactory(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit as Retrofit?;
        }
    }

}