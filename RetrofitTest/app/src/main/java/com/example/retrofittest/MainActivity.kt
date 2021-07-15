package com.example.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val appService = retrofit.create(AppService::class.java)
        appService.getAppData().enqueue(
            object: Callback<List<App>> {
                override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<List<App>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )

    }
}