package com.example.retrofitmvvmroomkotlin

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.retrofitmvvmroomkotlin.Model.Data
import com.example.retrofitmvvmroomkotlin.Model.MainData
import com.example.retrofitmvvmroomkotlin.RoomDatabase.AppDatabase
import com.example.retrofitmvvmroomkotlin.ViewModel.DataViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var  dataViewModel : DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = AppDatabase(this)
        dataViewModel =
            DataViewModel(applicationContext as Application)
        dataViewModel.fetchData();
        dataViewModel.mutableLiveData.observe(this, Observer {
            Log.d("MyData",it.toString())
            GlobalScope.launch {
                db.databaseDao().insertAll(it.data)
              var mainData :ArrayList<Data> = db.databaseDao().getAllData() as ArrayList<Data>
                Log.d("MyDatabaseData",mainData.toString())
            }
        })
    }
}
