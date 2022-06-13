package wordle

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.example.epikgames.R

const val HEIGHT = 6
const val WIDTH = 5

class Board(val tileArray: Array<Tile> = Array(HEIGHT * WIDTH) {i -> Tile(i)}) {
    private var curTile = 0
    private var guessMade = false
    private val wordList: ArrayList<String> = arrayListOf()

    fun guess() {
        guessMade = true
        var guessWord = ""
        var startTile = curTile - 4
        while (startTile <= curTile) {
            guessWord += tileArray[startTile].char.toString()
            startTile++
        }
        startTile = curTile - 4

        //Have an arraylist of words
        //Can add more words to list in Word class
        val wordList = getWords()

        //Pick a random word using index of arraylist(use this for
        //actual implementation)
        //val randIndex = Math.random() * wordList.size
        //val actualWord = wordList[randIndex.toInt()]

        //Change index of wordList for purpose of running test cases
        val actualWord = wordList[0]

        guessWord = guessWord.lowercase()


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
                tileArray[startTile + i].color = Color.GREEN
                //If characters don't match but character is found in both words, mark it as YELLOW
            } else if (wordOccur[guessWord[i].code - 97] > 0 && guessOccur[guessWord[i].code - 97] > 0) {
                tileArray[startTile + i].color = Color.YELLOW
                wordOccur[guessWord[i].code - 97]--
                guessOccur[guessWord[i].code - 97]--
            } else {
                //Mark character as GRAY
                tileArray[startTile + i].color = Color.GRAY
            }
        }
    }

    fun delete() {
        TODO("Not yet implemented")
    }

    fun type(char: Char) {
        if (guessMade) {
            guessMade = false
            curTile++
        }
        
        if (curTile >= tileArray.size - 1) {
            return
        }

        if (curTile % WIDTH == (WIDTH - 1)) {
            if (tileArray[curTile].char == ' ') {
                tileArray[curTile] = Tile(tileArray[curTile].id, char, 0)
            }
            return
        }

        tileArray[curTile] = Tile(tileArray[curTile].id, char,0)
        curTile++
    }

    fun getRow(): Int {
        return curTile / WIDTH
    }

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