package com.example.xmlnavapp2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SaveStateHandleViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _counter = MutableLiveData(0)
    val counter: LiveData<Int> = _counter

    fun updateCounter() {
        val counter = _counter.value ?: 0
        _counter.value = counter + 1
    }


    companion object {
        private const val NAME = "name"
        private const val AGE = "age"
    }

    var name: String?
        get() = savedStateHandle[NAME]
        set(value) {
            savedStateHandle[NAME] = value
        }

    var age: Int?
        get() = savedStateHandle[AGE]
        set(value) {
            savedStateHandle[AGE] = value
        }
}