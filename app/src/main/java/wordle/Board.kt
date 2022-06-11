package wordle

import android.view.View
import android.widget.TextView
import com.example.epikgames.R

const val HEIGHT = 6
const val WIDTH = 5

class Board(val tileArray: Array<Tile> = Array(HEIGHT * WIDTH) { i -> Tile(i) }) {
    private var curTile = 0
    private val colorChars: ArrayList<String> = arrayListOf()
    private val wordObj = Word()

    fun guess(guessWord: String): ArrayList<String> {

        //Have an arraylist of words
        //Can add more words to list in Word class
        val wordList = wordObj.getWords()

        //Pick a random word using index of arraylist

        //val randIndex = Math.random() * wordList.size
        //val actualWord = wordList[randIndex.toInt()]

        //Change index of wordList for purpose of running test cases
        val actualWord = wordList[1]


        //Have two arrays that will store the occurrences of characters in the guess word and actual word
        val wordOccur = IntArray(26)
        val guessOccur = IntArray(26)

        //Have the index of the array correspond to the character (a = 97)
        for (i in actualWord.indices) {
            wordOccur[actualWord[i].code - 97]++
            guessOccur[guessWord[i].code - 97]++
        }

        for (i in actualWord.indices) {
            //If characters match, mark it as GREEN
            if (actualWord[i] == guessWord[i]) {
                colorChars.add("GREEN")
                //If characters don't match but character is found in both words, mark it as YELLOW
            } else if (wordOccur[guessWord[i].code - 97] > 0 && guessOccur[guessWord[i].code - 97] > 0) {

                colorChars.add("YELLOW")
                wordOccur[guessWord[i].code - 97]--
                guessOccur[guessWord[i].code - 97]--
            } else {
                //Mark character as RED
                colorChars.add("GRAY")
            }
        }
        return colorChars
    }

    fun delete() {
        TODO("Not yet implemented")
    }

    fun type(char: Char) {
        if (curTile >= tileArray.size - 1) {
            return
        }

        if (curTile % WIDTH == (WIDTH - 1)) {
            if (tileArray[curTile].char == ' ') {
                tileArray[curTile] = Tile(tileArray[curTile].id, char)
            }
            return
        }

        tileArray[curTile] = Tile(tileArray[curTile].id, char)
        curTile++
    }

    fun getRow(): Int {
        return curTile / WIDTH
    }

}