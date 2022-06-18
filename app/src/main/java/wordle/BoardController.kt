package wordle

import WordsList


class BoardController() {
    private val words = WordsList.values()

    fun getRandWord(): String {
        return words.toList().shuffled().first().toString().uppercase()
    }

    fun getWords(): Array<WordsList> {
        return words
    }
}