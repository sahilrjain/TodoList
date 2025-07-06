package com.jainly.statemanagementtodolist.viewmodel

import androidx.lifecycle.ViewModel
import com.jainly.statemanagementtodolist.data.TodoScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoListViewModel : ViewModel() {

    private val _state = MutableStateFlow(TodoScreenState())
    val state = _state.asStateFlow()

    fun onCheckClicked(index: Int) {
        _state.update { currentState ->
            val updatedTodos = currentState.todos.toMutableList().apply {
                this[index] = this[index].copy(isChecked = !this[index].isChecked)
            }
            // Create new list with updated item
            currentState.copy(todos = updatedTodos)
        }
    }
}