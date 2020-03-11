package week2

import java.util.*



fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val a = scan.nextLine()

        val b = scan.nextLine()

        val result = morganAndStringTest(a, b)
        println(result)
    }


}

fun morganAndString(A: String, B: String): String {

    var i = 0
    var j = 0
    val sb = StringBuffer()

    while (i < A.length && j < B.length) {
        if (A[i] < B[j]) {
            sb.append(A[i++])
        } else if (A[i] > B[j]) {
            sb.append(B[j++])
        } else {
            var x = i
            var y = j
            var a = A[i]
            while (x < A.length && y < B.length) {
                if (A[x] !== B[y]) {
                    break
                } else if (A[x] > a) {
                    sb.append(A.substring(i, x)).append(B.substring(j, y))
                    i = x
                    j = y
                    a = A[x]
                }
                x++
                y++
            }

            if (x == A.length) {
                sb.append(B[j])
                j++
            } else if (y == B.length) {
                sb.append(A[i])
                i++
            } else {
                if (A[x] < B[y]) {
                    sb.append(A[i])
                    i++
                } else {
                    sb.append(B[j])
                    j++
                }
            }
        }
    }
    sb.append(A.substring(i)).append(B.substring(j));
    return sb.toString()
}


// Complete the morganAndString function below.
fun morganAndStringTest(a: String, b: String): String {
    val sb = StringBuilder()
    var i = 0
    var j = 0

    while (i < a.length && j < b.length) {
        if (a[i] < b[j]) {
            sb.append(a[i++]);
        } else if (a[i] > b[j]) {
            sb.append(b[j++])
        }else {
            if (a[i] < b[j]) {
                sb.append(a[i]);
                i++;
            } else {
                sb.append(b[j])
                j++;
            }
            if(j < b.length && i==a.length){
                sb.append(b[j])
                j++;
            }
        }

    }
    sb.append(a.substring(i)).append(b.substring(j));
    return sb.toString()

}
