package wordle

class Word(val word: String) {
    private var wordList = arrayListOf<String>()

     fun addWords() {
        //Adding 10 words for now
        //We can add a lot more words later
        wordList.add("hello")
        wordList.add("cards")
    }




}