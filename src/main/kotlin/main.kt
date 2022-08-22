import java.io.File
import kotlin.math.pow

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val m = (2.0).pow(25).toInt() - 1
    val a = (4.0).pow(3).toInt()
    val c = 21
    var x0 = 256
    val xs = ArrayList<Int>()
    var firstRepetition: Int? = null

    xs.add(x0)
    for (i in 1..n) {
        x0 = (a * x0 + c) % m

        if (firstRepetition == null && xs.contains(x0)) {
            firstRepetition = x0
            println("Found repetition at iteration: x$i")
            println("First repetition value: $firstRepetition")
        }
        xs.add(x0)
    }

    val sequence = xs.joinToString { i -> i.toString() }
    print("Sequence: $sequence")


    File("result.txt").printWriter().use { out ->
        out.println(sequence)
    }
}