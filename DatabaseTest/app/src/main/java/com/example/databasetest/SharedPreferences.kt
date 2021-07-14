package com.example.databasetest

import android.app.Application
import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences

fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.block()
    editor.apply()
}

fun add() {
    App.context.getSharedPreferences("data", Context.MODE_PRIVATE).open {

    }
}

fun cvOf(vararg pairs: Pair<String, Any?>) : ContentValues {

    val cv = ContentValues()

    for (pair in pairs) {
        val key = pair.first
        val value = pair.second
        when (value) {
            is Int -> cv.put(key, value)
        }
    }

    return cv

}