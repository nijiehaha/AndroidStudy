package com.example.helloworld

import kotlin.math.max

fun main() {

    Thread {
        println("Thread is Running")
    }.start()

//    println(listOf<Int>(1,2,3).maxOf { it })

//    val a = 37
//    val b = 40
//    val value = getScore("123")
//    println("larger number is $value")
//    val  p = Person()
//    p.name = "lufei"
//    p.age = 20
//    p.eat()
}

fun largerNumber(num1: Int, num2: Int):Int {
    return max(num1, num2)
}

fun getScore(name: String) = if (name == "Tom") {
    86
} else if (name == "Jim") {
    77
} else if (name == "Jack") {
    95
} else if (name == "Lily") {
    100
} else {
    0
}