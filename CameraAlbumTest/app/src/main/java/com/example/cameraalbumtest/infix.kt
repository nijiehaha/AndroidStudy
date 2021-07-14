package com.example.cameraalbumtest

infix fun String.beginWith(prefix: String) = startsWith(prefix)

fun add() {

    "ni" beginWith "n"

}