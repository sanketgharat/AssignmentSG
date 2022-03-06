package com.sg.assignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sg.assignment.data.DataRepository
import com.sg.assignment.data.models.MainData
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val repository: DataRepository

) : ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
        val FACTORY = singleArgViewModelFactory(::MainViewModel)
    }


    private val _dataList = MutableLiveData<List<MainData>?>()
    val dataList: LiveData<List<MainData>?> get() = _dataList


    fun getData() = viewModelScope.launch(IO) {
        Log.d(TAG, "getData: call")

        val data = repository.fetchData()

        data?.let {
            Log.d(TAG, "getData: success")
            _dataList.postValue(data)
        }

    }

}