package com.example.retrofitmvvmroomkotlin.RoomDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.retrofitmvvmroomkotlin.Model.Data
import com.example.retrofitmvvmroomkotlin.Model.MainData

@Dao
interface DatabaseDao {
    @Insert
    fun insertAll(mainData: ArrayList<Data>)

    @Query("SELECT * FROM MyData")
    fun getAllData(): List<Data>
}