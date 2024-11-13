fun main() {
    val rows = getPositiveInt("Введите количество строк для двумерного массива:")
    val cols = getPositiveInt("Введите количество столбцов для двумерного массива:")

    val array = Array(rows) { IntArray(cols) }

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            array[i][j] = getThreeDigitNumber(i, j)
        }
    }

    println("Двумерный массив:")
    array.forEach { println(it.joinToString(" ")) }

    val uniqueDigits = array.flatMap { it.asIterable() }
        .flatMap { it.toString().toList() }
        .toSet()

    println("В массиве использовано ${uniqueDigits.size} различных цифр.")
}

fun getPositiveInt(prompt: String): Int {
    while (true) {
        println(prompt)
        val input = readLine()?.toIntOrNull()
        if (input != null && input > 0) return input
        println("Ошибка: введите положительное целое число.")
    }
}

fun getThreeDigitNumber(row: Int, col: Int): Int {
    while (true) {
        println("Введите трехзначное число для позиции ($row, $col):")
        val input = readLine()?.toIntOrNull()
        if (input != null && input in 100..999) return input
        println("Ошибка: число должно быть трехзначным. Попробуйте снова.")
    }
}

