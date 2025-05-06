fun fibonacci(n: Int): Int {
    if  ( n <= 1) {
        return n
    }
    return fibonacci(n-1) + fibonacci(n-2)

}


fun main() {

    println("Digite a posição da sequência de Fibonacci:")
    val num = readln().toInt()
    println("Fibonacci($num) = ${fibonacci(num)}")

}