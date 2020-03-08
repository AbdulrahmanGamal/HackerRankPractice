package week1

import java.util.*
import kotlin.math.min

// Complete the minimumDistances function below.
private fun minimumDistances(a: Array<Int>): Int {
    // list  contains  distances
    val mapOfDistances = hashMapOf<Int, Int>()
    var minDistance = Integer.MAX_VALUE

    a.forEachIndexed { index, value ->
        if (mapOfDistances.containsKey(value)) {
            val distance = index - (mapOfDistances[value] ?: 0)
            mapOfDistances[value] = distance
            minDistance = min(minDistance, distance);
        } else {
            mapOfDistances[value] = index
        }
    }
    return if (minDistance == Integer.MAX_VALUE) -1 else minDistance
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = minimumDistances(a)

    println(result)
}
