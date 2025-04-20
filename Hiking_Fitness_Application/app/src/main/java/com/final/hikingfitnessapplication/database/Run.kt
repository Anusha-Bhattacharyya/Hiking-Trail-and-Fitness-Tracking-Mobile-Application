package com.example.hikingfitnessapplication.database

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")
data class Run (
    var img: Bitmap? = null,
    var timestamp: Long = 0L,
    var avgspeed: Float = 0f,
    var distance: Int = 0,
    var time: Long = 0L,
    var calories: Int = 0
    )
{
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}