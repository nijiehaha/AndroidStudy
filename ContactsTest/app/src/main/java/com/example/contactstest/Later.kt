package com.example.contactstest

import kotlin.reflect.KProperty

val p by Later {

}

class Later<T>(val block: () -> T) {

    var value: Any? = null

    operator fun getValue(any: Any?, prop: KProperty<*>) : T {
        if (value == null) {
            value = block()
        }
        return value as T
    }

}