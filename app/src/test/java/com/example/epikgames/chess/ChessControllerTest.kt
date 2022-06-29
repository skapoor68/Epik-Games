package com.example.epikgames.chess

import chess.ChessController
import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.Square
import com.github.bhlangonijr.chesslib.move.Move
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import java.lang.Exception

class ChessControllerTest {


    private val goodArray: Array<Int> = Array(64) { it }
    val controller = ChessController(goodArray)

    @Test
    fun createBoardControllerWithException() {
        val badArray: Array<Int> = arrayOf(1)

        assertThrows(Exception().javaClass) { ChessController(badArray) }
    }

    @Test
    fun movePieceTest() {
        val board = Board()
        val expectedBoard = Board()
        expectedBoard.doMove(Move(Square.B2, Square.B3))

        controller.movePiece(board, 9, 17)

        assertEquals(expectedBoard, board)
    }
}