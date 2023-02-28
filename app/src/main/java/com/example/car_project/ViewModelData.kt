package com.example.car_project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelData: ViewModel() {
    val name: MutableLiveData<String> = MutableLiveData()
}