package com.assignment.a10_final_project

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "TasksDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE Tasks(id INTEGER PRIMARY KEY AUTOINCREMENT, task TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Tasks")
        onCreate(db)
    }

    fun insertTask(task: String): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put("task", task)
        val result = db.insert("Tasks", null, values)
        return result != -1L
    }

    fun getTasks(): List<TaskModel> {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Tasks ORDER BY id DESC", null)
        val taskList = mutableListOf<TaskModel>()

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val task = cursor.getString(cursor.getColumnIndexOrThrow("task"))
            taskList.add(TaskModel(id, task))
        }
        cursor.close()
        return taskList
    }

    fun deleteTask(id: Int) {
        val db = writableDatabase
        db.delete("Tasks", "id=?", arrayOf(id.toString()))
    }
}