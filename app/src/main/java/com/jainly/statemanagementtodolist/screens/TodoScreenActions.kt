package com.jainly.statemanagementtodolist.screens

sealed interface TodoScreenActions {
    data class OnCheckClick(val index: Int) : TodoScreenActions
    data object OnAddTodoClick : TodoScreenActions
    data class OnDeleteClick(val index: Int) : TodoScreenActions
}