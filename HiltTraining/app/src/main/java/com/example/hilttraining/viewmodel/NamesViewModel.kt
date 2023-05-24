package com.example.hilttraining.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class NamesViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    private val dataSource = ArrayList<String>()
    private var _names = MutableLiveData<ArrayList<String>>()
    var names: LiveData<ArrayList<String>> = _names

    fun addName(name: String) {
        dataSource.add(name)
        _names.postValue(dataSource)
    }
}