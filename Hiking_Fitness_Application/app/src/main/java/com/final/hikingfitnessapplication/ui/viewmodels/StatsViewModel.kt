@file:Suppress("DEPRECATION")

package com.example.hikingfitnessapplication.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.hikingfitnessapplication.repositories.MainRepositories

class StatsViewModel @ViewModelInject constructor(
    val mainRepository: MainRepositories
): ViewModel() {

}