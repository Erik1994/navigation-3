package com.project.nivagation3.todo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoViewModel: ViewModel() {
    private val _todos = MutableStateFlow(
        (1..100).map { "Todo $it" }
    )
    val todos = _todos.asStateFlow()
}