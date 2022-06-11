package wordle

class Word() {
    private var wordList = arrayListOf<String>()

     fun getWords(): ArrayList<String> {
        //Adding 10 words for now
        //We can add a lot more words later
         wordList.add("hello")
         wordList.add("cards")
         wordList.add("irons")
         wordList.add("cattle")
         return wordList
     }




}