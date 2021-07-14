package com.example.databasetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = MyDatabaseHelper(this, "BookStore", 3)
        createDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }

        Toast.makeText(this.applicationContext, "", Toast.LENGTH_SHORT).show()

        getSharedPreferences("data", Context.MODE_PRIVATE).open {

        }

    }
}