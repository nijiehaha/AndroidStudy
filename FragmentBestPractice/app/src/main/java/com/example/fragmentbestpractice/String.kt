package com.example.fragmentbestpractice

import java.lang.StringBuilder

//operator fun String.times(n: Int): String {
//    val builder = StringBuilder()
//    repeat(n) {
//        builder.append(this)
//    }
//    return builder.toString()
//}

operator fun String.times(n: Int) = repeat(n)