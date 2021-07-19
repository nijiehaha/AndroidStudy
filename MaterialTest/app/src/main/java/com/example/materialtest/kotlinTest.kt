package com.example.materialtest

import kotlin.math.max

fun main() {
    val a = 10
    val b = 15
    val larger = max(a, b)

    val c = 5
    val largest = max(max(a, b), c)

}

fun max(vararg nums: Int): Int {
    var maxNum = Int.MIN_VALUE
    for (num in nums) {
        maxNum = max(maxNum, num)
    }
    return maxNum
}