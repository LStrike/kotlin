fun main(args: Array<String>) {
    ggt(123, 456)
    println("SUM: " + sumUpTo(2))
    println("isEven: " + isEven(11) + " isOdd: "+ isOdd(11))
    println(sieve(100))
}

// Berechnet den größten gemeinsamen Teiler
fun ggt(x: Int = 0, y: Int = 0): Int {
    var a: Int = x
    var b: Int = y

    while (b != 0) {
        if (a > b) {
            a -= b
        } else {
            b -= a
        }
    }

    println("Der ggT von $x und $y ist $a.")
    return a
}


fun sumUpTo(x: Int): Int {
    var result = 0
    var a = x

    while (a > 0) {
        result += a
        a--
    }
    return result
}

fun isEven(x: Int): Boolean{
    if(x%2==0){
        return true
    }else {
        return false
    }
}

fun isOdd(x: Int): Boolean{
    return !isEven(x)
}

fun sieve(limit: Int): List<Int> {
    val primes = mutableListOf<Int>()

    if (limit >= 2) {
        val numbers = Array(limit + 1) { true }
        val sqrtLimit = Math.sqrt(limit.toDouble()).toInt()

        for (factor in 2..sqrtLimit) {
            if (numbers[factor]) {
                for (multiple in (factor * factor)..limit step factor) {
                    numbers[multiple] = false
                }
            }
        }

        numbers.forEachIndexed { number, isPrime ->
            if (number >= 2) {
                if (isPrime) {
                    primes.add(number)
                }
            }
        }
    }

    return primes
}
