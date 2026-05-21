package com.project.nivagation3.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel: ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    init {
       println("LoginViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        println("LoginViewModel cleared")
    }

    fun increment() {
        _counter.value++
    }
}