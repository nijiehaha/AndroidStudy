package com.example.viewmodeltest

fun main() {
    dependency {

        implementation("")

    }
}

fun dependency(block: Dependency.() -> Unit): List<String> {
    val dependency = Dependency()
    dependency.block()
    return dependency.libraries
}

class Dependency {
    val libraries = ArrayList<String>()
    fun implementation(lib: String) {
        libraries.add(lib)
    }



}