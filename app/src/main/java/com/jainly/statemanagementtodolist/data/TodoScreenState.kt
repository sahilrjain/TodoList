package com.jainly.statemanagementtodolist.data

data class TodoScreenState(
    val isLoading: Boolean = false,
    val todos: List<TodoItem> = listOf(
        TodoItem("Title",
            "description",
            false)
    ),
    val errorMessages: String? = null
)