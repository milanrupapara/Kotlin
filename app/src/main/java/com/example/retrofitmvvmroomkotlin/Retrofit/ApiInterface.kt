package com.example.retrofitmvvmroomkotlin.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.retrofitmvvmroomkotlin.Model.MainData

interface ApiInterface {
    @GET("users")
    fun getData(@Query("page") page : Int): Call<MainData>
}