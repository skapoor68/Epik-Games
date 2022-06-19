package wordle

import android.app.PendingIntent.getActivity
import android.graphics.Color
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.epikgames.R
import com.example.epikgames.activities.WordleActivity
import kotlinx.coroutines.processNextEventInCurrentThread
import java.security.AccessController.getContext

const val HEIGHT = 6
const val WIDTH = 5

enum class BoardColor(val rgb: String) {
    GREEN("#6ca965"),
    YELLOW("#c8b653"),
    DARK_GRAY("#787c7f"),
    WHITE("#ffffff")
}

class Board(val letterStatus: Array<Int> = Array(26) { _ -> -1}, val tileArray: Array<Tile> = Array(HEIGHT * WIDTH) { i -> Tile(i)}, val solution: String) {
    private var curTile = 0
    private var typedLetters = 0
    private var guessMade = false

    fun guess() {
        guessMade = true
        var guessWord = ""
        var startTile = curTile - 4
        while (startTile <= curTile) {
            guessWord += tileArray[startTile].char.toString()
            startTile++
        }
        println(guessWord)
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
                tileArray[startTile + i].color = BoardColor.GREEN
                letterStatus[guessWord[i].code - 65] = 2
                //If characters don't match but character is found in both words, mark it as YELLOW
            } else if (wordOccur[guessWord[i].code - 65] > 0 && guessOccur[guessWord[i].code - 65] > 0) {
                tileArray[startTile + i].color = BoardColor.YELLOW
                if (letterStatus[guessWord[i].code - 65] != 2) {
                    letterStatus[guessWord[i].code - 65] = 1
                }
                wordOccur[guessWord[i].code - 65]--
                guessOccur[guessWord[i].code - 65]--
            } else {
                //Mark character as GRAY
                if (letterStatus[guessWord[i].code - 65] < 1) {
                    letterStatus[guessWord[i].code - 65] = 0
                }
                tileArray[startTile + i].color = BoardColor.DARK_GRAY
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
        
        if (curTile > tileArray.size - 1) {
            return
        }

        if (curTile % WIDTH == (WIDTH - 1)) {
            if (tileArray[curTile].char == ' ') {
                tileArray[curTile] = Tile(tileArray[curTile].id, char, BoardColor.WHITE)
            }
            return
        }

        tileArray[curTile] = Tile(tileArray[curTile].id, char,BoardColor.WHITE)
        curTile++
        //increment the amount of letters typed in a given row (set to 1 for new row)
        if (curTile % WIDTH == 1) {
            typedLetters = 1
        } else {
            typedLetters++
        }
    }

    fun getRow(): Int {
        return curTile / WIDTH
    }

    fun getTypedLetters() : Int {
        return typedLetters
    }

    fun getCurTile() : Int {
        return curTile
    }
}