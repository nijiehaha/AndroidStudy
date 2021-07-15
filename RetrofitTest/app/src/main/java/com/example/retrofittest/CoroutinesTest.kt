package com.example.retrofittest

import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun request(address: String): String {

    return suspendCoroutine {
        it.resume("")
    }

}

fun main() {

    runBlocking {

        val result = withContext(Dispatchers.Default) {

        }

    }

    runBlocking {

        val start = System.currentTimeMillis()
        val deferred1 = async {

        }
        val deferred2 = async {

        }

    }

    runBlocking {
        val result = async {
            5 + 5
        }.await()
        println(result)
    }

//    val job = Job()
//    val scope = CoroutineScope(job)
//    scope.launch {
//
//    }
//    job.cancel()
//
//
//    runBlocking {
//
//        launch {
//            println("launch1")
//            delay(1000)
//            println("launch1 finished")
//        }
//
//        launch {
//            println("launch2")
//            delay(1000)
//            println("launch2 finished")
//        }
//
//    }

//    GlobalScope.launch {
//        println("codes run in coroutine scope")
//    }
//    Thread.sleep(1000)
}

suspend fun printDot() = coroutineScope {
    launch {
        println(".")
        delay(1000)
    }
}