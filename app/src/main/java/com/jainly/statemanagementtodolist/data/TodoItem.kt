package com.jainly.statemanagementtodolist.data

data class TodoItem(
    val id: Int,
    val title: String,
    val description: String,
    val isChecked: Boolean
)