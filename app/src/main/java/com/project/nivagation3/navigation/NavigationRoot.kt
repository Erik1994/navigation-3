package com.project.nivagation3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.project.nivagation3.features.TodoListDetailsScreen
import com.project.nivagation3.features.TodoListScreen

@Composable
fun NavigationRoot(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(Route.TodoList)
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator {
                true
            }
        ),
        entryProvider = { key ->
            when (key) {
                is Route.TodoList -> {
                    NavEntry(
                        key = key,
                    ) {
                        TodoListScreen(
                            onTodoClick = { todoId ->
                                backStack.add(Route.TodoDetail(todoId))
                            }
                        )
                    }
                }

                is Route.TodoDetail -> {
                    NavEntry(
                        key = key
                    ) {
                        TodoListDetailsScreen(
                            todo = key.todo
                        )
                    }
                }

                else -> error("Unknown route: $key")
            }
        }
    )
}
