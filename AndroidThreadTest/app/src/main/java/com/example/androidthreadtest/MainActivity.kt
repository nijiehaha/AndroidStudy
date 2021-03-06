package com.example.androidthreadtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val updateText = 1

    val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread {
            textView.text = "nice to meet you"
//                handler.post {
//                    textView.text = "nice to meet you"
//                }
        }

        changeTextBtn.setOnClickListener {
            thread {
                textView.text = "nice to meet you"
//                handler.post {
//                    textView.text = "nice to meet you"
//                }
            }
        }

    }
}