package com.example.hikingfitnessapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table ORDER BY timestamp")
    fun getallRunsDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY time")
    fun getallRunsTime(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY calories")
    fun getallRunsCalories(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgspeed")
    fun getallRunsSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distance")
    fun getallRunsDistance(): LiveData<List<Run>>

    @Query("SELECT SUM(distance) FROM running_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT SUM(time) FROM running_table")
    fun getTotalTime(): LiveData<Long>

    @Query("SELECT SUM(calories) FROM running_table")
    fun getTotalCalories(): LiveData<Int>

    @Query("SELECT SUM(avgspeed) FROM running_table")
    fun getTotalAvgSpeed(): LiveData<Float>
}