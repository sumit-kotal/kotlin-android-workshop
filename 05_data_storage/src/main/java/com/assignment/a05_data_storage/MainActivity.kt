package com.assignment.a05_data_storage

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText = findViewById<EditText>(R.id.editText)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val buttonLoad = findViewById<Button>(R.id.buttonLoad)
        val textView = findViewById<TextView>(R.id.textView)

        val sharedPref = getSharedPreferences("UserPref", Context.MODE_PRIVATE)

        buttonSave.setOnClickListener {
            val username = editText.text.toString()
            sharedPref.edit().putString("USERNAME", username).apply()
        }

        buttonLoad.setOnClickListener {
            val username = sharedPref.getString("USERNAME", "No name saved")
            textView.text = "Saved Username: $username"
        }


        /*val db = DatabaseHelper(this)

        val editText = findViewById<EditText>(R.id.editText)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val buttonLoad = findViewById<Button>(R.id.buttonLoad)
        val textView = findViewById<TextView>(R.id.textView)

        buttonSave.setOnClickListener {
            val username = editText.text.toString()
            db.insertUser(username)
        }

        buttonLoad.setOnClickListener {
            val username = db.getUser()
            textView.text = "Saved Username: $username"
        }*/

    }
}