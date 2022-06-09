package wordle

import android.view.View
import android.widget.TextView
import com.example.epikgames.R

const val HEIGHT = 6
const val WIDTH = 5

class Board(val tileArray: Array<Tile> = Array(HEIGHT * WIDTH) { i -> Tile(i) }) {
    private var curTile = 0

    fun guess() {
        // get characters from board and put it in a string
        // see if string matches string in string list
        //Have an arraylist of words
        //Pick a random word using index of arraylist


        val wordList = ArrayList<Word>()
        wordList.add(Word("hello"))
        wordList.add(Word("cards"))

        val randIndex = Math.random() * wordList.size
        val actualWord = wordList[randIndex.toInt()]
        val charArray = charArrayOf()

        val charOccur = IntArray(26)
        val word = "hosle"
        val guess = "helol"

        for (i in word.indices) {
            charOccur[word[i].code - 97]++
            charOccur[guess[i].code - 97]--
        }

        val colorChars: ArrayList<String> = arrayListOf()

        println(charOccur.asList())

        for (i in word.indices) {
            if (word[i] == guess[i]) {
                colorChars.add("GREEN")
            } else if (charOccur[guess[i].code - 97] != 0) {
                colorChars.add("GRAY")
            } else {
                colorChars.add("YELLOW")
            }
        }
        println(colorChars)




        TODO("Not yet implemented")
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