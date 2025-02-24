package com.assignment.a05_data_storage

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "UserDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE Users(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Users")
        onCreate(db)
    }

    fun insertUser(name: String): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put("name", name)
        val result = db.insert("Users", null, values)
        return result != -1L
    }

    fun getUser(): String {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Users ORDER BY id DESC LIMIT 1", null)
        return if (cursor.moveToFirst()) {
            cursor.getString(cursor.getColumnIndexOrThrow("name"))
        } else {
            "No users found"
        }.also { cursor.close() }
    }
}