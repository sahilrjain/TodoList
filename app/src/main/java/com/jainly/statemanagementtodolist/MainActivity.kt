package com.jainly.statemanagementtodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.jainly.statemanagementtodolist.screens.TodoScreenRoot
import com.jainly.statemanagementtodolist.ui.theme.StateManagementTodoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateManagementTodoListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TodoScreenRoot(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}