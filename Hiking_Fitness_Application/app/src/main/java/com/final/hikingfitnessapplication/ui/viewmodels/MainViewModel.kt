package com.example.hikingfitnessapplication.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hikingfitnessapplication.database.Run
import com.example.hikingfitnessapplication.repositories.MainRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepositories
): ViewModel() {

    val runsSortedByDate = mainRepository.getallRunsDate()

    fun insertRun(run: Run) = viewModelScope.launch {
        mainRepository.insertRun(run)
    }

}