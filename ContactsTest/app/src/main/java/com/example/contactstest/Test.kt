package com.example.contactstest

import kotlin.reflect.KProperty

fun main() {
    val value = add
    val value1 = add
}

val add by lazy {
    print(123)
}

class MyClass<T> {

    val p by Delegate()

//    fun method(param: T): T {
//        return param
//    }

}

class MySet<T>(val helperSet: HashSet<T>) : Set<T> by helperSet {

    val name:String by lazy {
        "123"
    }




//    override val size: Int
//        get() = helperSet.size
//
//    override fun contains(element: T) = helperSet.contains(element)
//
//    override fun containsAll(elements: Collection<T>) = helperSet.containsAll(elements)
//
//    override fun isEmpty() = helperSet.isEmpty()
//
//    override fun iterator() = helperSet.iterator()

}

fun add() {
    val myClass = MyClass<String>()
//    myClass.method(1)
}

class Delegate<T> {
    var propValue: Any? = null
    operator fun getValue(myClass: MyClass<T>, prop: KProperty<*>) : Any? {
        return propValue
    }
    operator fun setValue(myClass: MyClass<T>, prop: KProperty<*>, value: Any?) {
        propValue = value
    }
}