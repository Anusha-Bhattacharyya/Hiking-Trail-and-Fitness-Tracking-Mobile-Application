package com.example.hikingfitnessapplication.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hikingfitnessapplication.R
import com.example.hikingfitnessapplication.ui.viewmodels.StatsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatsFragment: Fragment(R.layout.fragment_statistics) {
    private val viewModel: StatsViewModel by viewModels()
}