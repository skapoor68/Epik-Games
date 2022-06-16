package wordle

class BoardController() {
    private val wordList: ArrayList<String> = arrayListOf()

    init {
        wordList.add("HELLO")
        wordList.add("CARDS")
        wordList.add("IRONS")
        wordList.add("WORDS")
        wordList.add("SAMMY")
    }

    fun getRandWord(): String {
        val randIndex = Math.random() * wordList.size
        return wordList[randIndex.toInt()]
    }

}