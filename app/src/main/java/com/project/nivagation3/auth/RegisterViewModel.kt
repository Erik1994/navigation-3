package com.project.nivagation3.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel: ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    init {
        println("RegisterViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        println("RegisterViewModel cleared")
    }

    fun increment() {
        _counter.value++
    }
}