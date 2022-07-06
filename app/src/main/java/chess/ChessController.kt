package chess

import android.widget.GridLayout
import android.widget.Toast
import com.example.epikgames.activities.ChessActivity
import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.Square
import com.github.bhlangonijr.chesslib.move.Move
import java.lang.Exception
import java.lang.IllegalArgumentException

class ChessController(tileIdArr: Array<Int>) {
    private val tileIdSquareMap = mutableMapOf<Int, Square>()

    init {
        if (tileIdArr.size < 64) {
            throw Exception()
        }

        val squareValues = Square.values()

        for (i in 0..63) {
            tileIdSquareMap[tileIdArr[i]] = squareValues[i]
        }
    }

    fun movePiece(board: Board, tileIdOne: Int, tileIdTwo: Int) {
        val squareOne = getSquare(tileIdOne)
        val squareTwo = getSquare(tileIdTwo)
        if (board.legalMoves().contains(Move(squareOne, squareTwo))) {
            board.doMove(Move(squareOne, squareTwo), true)
        }
    }

    fun chessScenarios(board: Board): Int {
        if (board.isMated) {
            return 0
        }

        if (board.isDraw) {
            return 1
        }

        if (board.isStaleMate) {
            return 2
        }
        return -1
    }

    fun undo(board: Board) {
        try {
            board.undoMove()
        } catch (e: Exception) {

        }

    }

    fun resign() {
        TODO()
    }

    fun getSquare(tileId: Int): Square {
        if (tileIdSquareMap[tileId] == null) {
            throw IllegalArgumentException("Not a valid tileId")
        }

        return tileIdSquareMap[tileId]!!
    }

}