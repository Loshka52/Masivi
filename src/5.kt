fun main() {
    println("Введите слова через пробел:")
    val input = readLine() ?: ""
    val words = input.split(" ")

    val groupedWords = groupAnagrams(words)

    println("Сгруппированные анаграммы:")
    for (group in groupedWords) {
        println(group.joinToString(", "))
    }
}

fun groupAnagrams(words: List<String>): List<List<String>> {
    val anagramsMap = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")
        anagramsMap.computeIfAbsent(sortedWord) { mutableListOf() }.add(word)
    }

    return anagramsMap.values.toList()
}
