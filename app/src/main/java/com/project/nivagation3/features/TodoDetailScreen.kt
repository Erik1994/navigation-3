package com.project.nivagation3.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.nivagation3.viewModel.TodoDetailViewModel

@Composable
fun TodoListDetailsScreen(
    modifier: Modifier = Modifier,
    todo: String,
    viewModel: TodoDetailViewModel = viewModel {
        TodoDetailViewModel(todo)
    }
) {
    val todo by viewModel.todos.collectAsStateWithLifecycle()
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = todo.todo,
            style = MaterialTheme.typography.titleLarge
        )
    }

}