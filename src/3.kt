fun main() {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ"
    val indexMap = alphabet.withIndex().associate { (index, char) -> char to index + 1 }

    println("Введите ключевое слово:")
    val keyword = readLine()!!.toUpperCase()
    println("Введите текст для шифрования:")
    val message = readLine()!!.toUpperCase()

    val encryptedMessage = encryptMessage(message, keyword, indexMap, alphabet)
    println("Зашифрованный текст: $encryptedMessage")
}

fun encryptMessage(message: String, keyword: String, indexMap: Map<Char, Int>, alphabet: String): String {
    return message.mapIndexed { i, char ->
        if (char in indexMap) {
            val shift = indexMap[keyword[i % keyword.length]] ?: 0
            val originalIndex = indexMap[char]!! - 1
            val newIndex = (originalIndex + shift) % alphabet.length
            alphabet[newIndex]
        } else {
            char // Если символ не буква, добавляем его без изменений
        }
    }.joinToString("")
}
