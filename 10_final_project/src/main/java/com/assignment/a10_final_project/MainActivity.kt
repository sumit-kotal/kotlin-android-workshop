package com.assignment.a10_final_project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var db: DatabaseHelper
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskAdapter
    private lateinit var editText: EditText
    private lateinit var buttonAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DatabaseHelper(this)
        recyclerView = findViewById(R.id.recyclerView)
        editText = findViewById(R.id.editTextTask)
        buttonAdd = findViewById(R.id.buttonAdd)

        recyclerView.layoutManager = LinearLayoutManager(this)
        loadTasks()

        buttonAdd.setOnClickListener {
            val taskText = editText.text.toString()
            if (taskText.isNotEmpty()) {
                db.insertTask(taskText)
                editText.text.clear()
                loadTasks()
            }
        }
    }

    private fun loadTasks() {
        val taskList = db.getTasks()
        adapter = TaskAdapter(taskList) { id ->
            db.deleteTask(id)
            loadTasks()
        }
        recyclerView.adapter = adapter
    }
}