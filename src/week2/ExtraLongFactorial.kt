package week2

import java.math.*
import java.util.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

// Problem link https://www.hackerrank.com/challenges/extra-long-factorials
// Complete the week2.extraLongFactorials function below.
fun extraLongFactorials(n: Int): Unit {
    var result = BigInteger("1")
    for (i in n downTo 1) {
        result = result.multiply(BigInteger.valueOf(i.toLong()))
    }
    println(result)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    extraLongFactorials(n)
}
