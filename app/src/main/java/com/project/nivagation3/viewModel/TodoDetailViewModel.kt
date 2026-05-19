package com.project.nivagation3.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoDetailViewModel(
    private val todo: String
): ViewModel() {
    private val _state = MutableStateFlow(
        TodoDetailState(todo)
    )
    val todos =_state.asStateFlow()

    init {
        println("TodoDetailViewModel created for $todo")
    }

    override fun onCleared() {
        super.onCleared()
        println("TodoDetailViewModel cleared for $todo")
    }
}

data class TodoDetailState(
    val todo: String
)