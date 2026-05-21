package com.project.nivagation3.todo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.project.nivagation3.navigation.Route

@Composable
fun TodoNavigation(modifier: Modifier = Modifier) {
    val todoBackStack = rememberNavBackStack(Route.Todo.TodoList)
    NavDisplay(
        modifier = modifier,
        backStack = todoBackStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Route.Todo.TodoList> {
                TodoListScreen(
                   onTodoClick = { todoId ->
                        todoBackStack.add(Route.Todo.TodoDetail(todoId))
                    }
                )
            }

            entry<Route.Todo.TodoDetail> {
                TodoListDetailsScreen(
                    todo = it.todo
                )
            }
        }
    )
}
