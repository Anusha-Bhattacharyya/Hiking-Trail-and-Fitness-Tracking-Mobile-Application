package com.example.hikingfitnessapplication.dependencyimplementation

import android.content.Context
import androidx.room.Room
import com.example.hikingfitnessapplication.database.RunningDatabase
import com.example.hikingfitnessapplication.other.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppMod {
    @Singleton
    @Provides
    fun giveRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun giveRunDao(db: RunningDatabase) = db.getRunDao()
}