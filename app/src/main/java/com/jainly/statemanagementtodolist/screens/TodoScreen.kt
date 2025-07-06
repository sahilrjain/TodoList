package com.jainly.statemanagementtodolist.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jainly.statemanagementtodolist.viewmodel.TodoListViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jainly.statemanagementtodolist.data.TodoItem

@Composable
fun TodoScreenRoot(
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<TodoListViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    TodoScreen(
        state.todos,
        viewModel::onCheckClicked
    )
}

@Composable
fun TodoScreen(
    todos: List<TodoItem>,
    onCheckedChange: (Int) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(todos) { index, item ->
            TodoItem(index, item, onCheckedChange)
        }
    }
}

@Composable
fun TodoItem(index: Int, todo: TodoItem, onCheckedChange: (Int) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Column(
            modifier = Modifier.padding(16.dp).weight(0.9f),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = todo.title,
                fontWeight = FontWeight.Bold,
                textDecoration = if (todo.isChecked) {
                    TextDecoration.LineThrough
                } else TextDecoration.None
            )
            Text(
                text = todo.description,
                textDecoration = if (todo.isChecked) {
                    TextDecoration.LineThrough
                } else TextDecoration.None
            )
        }
        Checkbox(
            modifier = Modifier.weight(0.1f),
            checked = todo.isChecked,
            onCheckedChange = { onCheckedChange(index) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TodoItemPreview() {
    TodoScreen(
        listOf(TodoItem("Title", "description", false)),
        onCheckedChange = {}
    )
}