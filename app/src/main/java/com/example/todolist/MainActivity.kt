package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    private lateinit var rvTodoItems: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems = findViewById(R.id.rvTodoItems)

        rvTodoItems.adapter = todoAdapter

        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo).setOnClickListener {
            val etTodoTitle = findViewById<EditText>(R.id.etTodoTitle)
            val todoTile = etTodoTitle.text.toString()
            if (todoTile.isNotEmpty()) {
                val todo = Todo(todoTile)
                todoAdapter.addTodo(todo);
                etTodoTitle.text.clear()
            }
        }

        val btnDeleteDoneTodos = findViewById<Button>(R.id.btnDeleteDoneTodos).setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}