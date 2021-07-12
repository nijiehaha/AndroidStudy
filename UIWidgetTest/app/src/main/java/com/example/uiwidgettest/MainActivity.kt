package com.example.uiwidgettest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    
    companion object {
        private const val TAG = "MainActivity"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        button.setOnClickListener {
//
//        }
        button.setOnClickListener(this)

    }
    override fun onClick(v:View?) {
        when (v?.id) {
            R.id.button -> {
//                Log.d(TAG, "onClick: 123")
//                val inputText = editText.text.toString()
//                Toast.makeText(applicationContext, inputText, Toast.LENGTH_SHORT).show()
//                imageView.setImageResource(R.drawable.lufei)
//                if (progressBar.visibility == View.VISIBLE) {
//                    progressBar.visibility = View.GONE
//                } else {
//                    progressBar.visibility = View.VISIBLE
//                }
//                progressBar.progress = progressBar.progress + 10

                AlertDialog.Builder(this).apply {
                    setTitle("This is Dialog")
                    setMessage("Something important")
                    setCancelable(false)
                    setPositiveButton("OK") { dialog, which ->

                    }
                    setNegativeButton("Cancel") { dialog, which ->

                    }
                    show()
                }

            }
        }
    }
}