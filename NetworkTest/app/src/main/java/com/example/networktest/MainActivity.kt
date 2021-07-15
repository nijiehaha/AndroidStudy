package com.example.networktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendRequestBtn.setOnClickListener {
//            sendRequestWithHttpUrlConnection()

            val json = "{\"name\":\"Tom\",\"age\":20}"

            val gson = Gson()
            val person = gson.fromJson(json, Person::class.java)

            Log.d(TAG, "onCreate: ${person.name}")

        }
    }

    fun sendRequestWithHttpUrlConnection() {
        thread {
//            var connection: HttpURLConnection? = null
            try {

                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("https://www.baidu.com")
                    .build()
                val response = client.newCall(request)
                    .execute()
                var responseData = response.body?.string()
                responseData?.let {
                    showResponse(it)
                }


//                val response = StringBuilder()
//                val url = URL("https://www.baidu.com")
//                connection = url.openConnection() as HttpURLConnection
//                connection.connectTimeout = 8000
//                connection.readTimeout = 8000
//                val input = connection.inputStream
//                val reader = BufferedReader(InputStreamReader(input))
//                reader.use {
//                    reader.forEachLine {
//                        response.append(it)
//                    }
//                }
//                showResponse(response.toString())
            } catch (e: Exception) {

            } finally {

            }
        }
    }

    fun showResponse(response: String) {
        runOnUiThread {
            responseText.text = response
        }
    }

}