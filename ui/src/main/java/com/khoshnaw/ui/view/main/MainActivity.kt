package com.khoshnaw.ui.view.main

import androidx.activity.viewModels
import com.khoshnaw.ui.databinding.ActivityMainBinding
import com.khoshnaw.ui.extenstion.dataBindings
import com.khoshnaw.ui.base.activity.MVIActivity
import com.khoshnaw.viewmodel.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : MVIActivity<ActivityMainBinding, MainViewModel>() {
    override val binding by dataBindings(ActivityMainBinding::inflate)
    override val viewModel: MainViewModel by viewModels()
}
