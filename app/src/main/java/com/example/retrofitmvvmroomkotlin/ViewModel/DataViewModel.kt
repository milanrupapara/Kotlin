package com.example.retrofitmvvmroomkotlin.ViewModel

import android.app.Application
import android.content.ContentValues.TAG
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmvvmroomkotlin.Retrofit.ApiClient
import com.example.retrofitmvvmroomkotlin.Retrofit.ApiInterface
import com.example.retrofitmvvmroomkotlin.Model.MainData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log





class DataViewModel(application: Application) : AndroidViewModel(application) {
    var mutableLiveData : MutableLiveData<MainData> = MutableLiveData()
    fun fetchData(){
        var apiInterface = ApiClient.apiClient.getApiClient()!!.create(ApiInterface::class.java)
        var mainData : Call<MainData> = apiInterface.getData(2);
        mainData.enqueue(object : Callback<MainData> {
            override fun onResponse(
                call: Call<MainData>,
                response: Response<MainData>
            ) {
                val mainData : MainData = response.body()
                Log.d(TAG, "Number of movies received: " + mainData.total)
                mutableLiveData.value = mainData
            }

            override fun onFailure(call: Call<MainData>, t: Throwable) {
                // Log error here since request failed
                Log.e(TAG, t.toString())
            }
        })
    }
}