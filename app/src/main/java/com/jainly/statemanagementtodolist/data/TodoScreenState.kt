package com.jainly.statemanagementtodolist.data

data class TodoScreenState(
    val isLoading: Boolean = false,
    val todos: List<TodoItem> = listOf(
        TodoItem(0,"Title",
            "description",
            false),
        TodoItem(1,"Title",
            "description",
            false)
    ),
    val errorMessages: String? = null
)