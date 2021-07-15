package com.example.retrofittest

import android.telecom.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import kotlin.coroutines.suspendCoroutine

class Data(val id: String, val content: String)

// http://example.com/get_data.json
interface ExampleService {
    @Headers("xixi:hahah", "xixix:xixixi")
    @GET("{page}/get_data.json")
    fun getData(@Path("page") page: Int): retrofit2.Call<Data>

}

class App(val id: String, val name: String, val version: String)

interface AppService {
    @GET("get_data.json")
    fun getAppData(): retrofit2.Call<List<App>>
}

interface Listener {
    fun add()
}

fun myAdd(num:Int, listener: Listener) {
    listener.add()
}

suspend fun <T> retrofit2.Call<T>.await() {
    return suspendCoroutine {

        enqueue( object : Callback<T> {
            override fun onResponse(call: retrofit2.Call<T>, response: Response<T>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: retrofit2.Call<T>, t: Throwable) {
                TODO("Not yet implemented")
            }

        }

        )

    }
}

fun main() {

    val appService = ServiceCreator.create(AppService::class.java)
    appService.getAppData().enqueue(object : Callback<List<App>> {
        override fun onResponse(call: retrofit2.Call<List<App>>, response: Response<List<App>>) {
            TODO("Not yet implemented")
        }

        override fun onFailure(call: retrofit2.Call<List<App>>, t: Throwable) {
            TODO("Not yet implemented")
        }

    })

    myAdd(1, object : Listener{
        override fun add() {
            TODO("Not yet implemented")
        }
    })
}