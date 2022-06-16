package wordle

import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.epikgames.R

const val HEIGHT = 6
const val WIDTH = 5

class Board(val tileArray: Array<Tile> = Array(HEIGHT * WIDTH) {i -> Tile(i)}, val solution: String) {
    private var curTile = 0
    private var guessMade = false

    fun guess() {
        guessMade = true
        var guessWord = ""
        var startTile = curTile - 4
        while (startTile <= curTile) {
            guessWord += tileArray[startTile].char.toString()
            startTile++
        }

        startTile = curTile - 4

        //Have two arrays that will store the occurrences of characters in the guess word and actual word
        val wordOccur = IntArray(26)
        val guessOccur = IntArray(26)

        //Have the index of the array correspond to the character (a = 97)
        for (i in solution.indices) {
            wordOccur[solution[i].code - 65]++
            guessOccur[guessWord[i].code - 65]++
        }

        for (i in solution.indices) {
            //If characters match, mark it as GREEN
            if (solution[i] == guessWord[i]) {
                tileArray[startTile + i].color = Color.GREEN
                //If characters don't match but character is found in both words, mark it as YELLOW
            } else if (wordOccur[guessWord[i].code - 65] > 0 && guessOccur[guessWord[i].code - 65] > 0) {
                tileArray[startTile + i].color = Color.YELLOW
                wordOccur[guessWord[i].code - 65]--
                guessOccur[guessWord[i].code - 65]--
            } else {
                //Mark character as GRAY
                tileArray[startTile + i].color = Color.GRAY
            }
        }
    }

    fun checkGuess(): Boolean {
        var startTile = curTile - 4
        while (startTile <= curTile) {
            if (tileArray[startTile].color != Color.GREEN) {
                return false
            }
            startTile++
        }
        return true
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



}