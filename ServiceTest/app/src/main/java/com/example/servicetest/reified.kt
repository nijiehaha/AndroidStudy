package com.example.servicetest

import android.content.Context
import android.content.Intent

inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}

open class Person(val name: String, val age: Int)
class Student(name:String, age: Int) : Person(name, age)
class Teacher(name:String, age: Int) : Person(name, age)

class SimpleData<out T>(val data: T?) {
//    private var data: T? = null
//    fun set(t: T?) {
//        data = t
//    }
    fun get(): T? {
        return data
    }
}

fun main() {
    val student = Student("Tom", 19)
    val data = SimpleData<Student>(student)
//    data.set(student)
    handleSimpleData(data)
    val studentData = data.get()
}

fun handleSimpleData(data: SimpleData<Person>) {
    val teacher = Teacher("Jack", 35)
//    data.set(teacher)
}