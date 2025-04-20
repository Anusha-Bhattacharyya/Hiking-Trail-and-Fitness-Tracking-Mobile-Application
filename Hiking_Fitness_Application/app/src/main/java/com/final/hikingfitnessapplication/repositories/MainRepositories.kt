package com.example.hikingfitnessapplication.repositories

import com.example.hikingfitnessapplication.database.Run
import com.example.hikingfitnessapplication.database.RunDAO
import javax.inject.Inject

class MainRepositories @Inject constructor(
    val runDao: RunDAO
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)
    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)
    fun getallRunsDate() = runDao.getallRunsDate()
    fun getallRunsDistance() = runDao.getallRunsDistance()
    fun getallRunsTime() = runDao.getallRunsTime()
    fun getallRunsAvgSpeed() = runDao.getallRunsSpeed()
    fun getallRunsCalories() = runDao.getallRunsCalories()
    fun getTotalSpeed() = runDao.getTotalAvgSpeed()
    fun getTotalDistance() = runDao.getTotalDistance()
    fun getTotalCalories() = runDao.getTotalCalories()
    fun getTotalTime() =   runDao.getTotalTime()
}