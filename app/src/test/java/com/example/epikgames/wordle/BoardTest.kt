package com.example.epikgames.wordle

import junit.framework.Assert.assertEquals
import org.junit.Test
import wordle.Board

class BoardTest {
    @Test
    fun createEmptyBoard() {
        val board: Board = Board()

        assertEquals(board.tileArray.size, 30)
    }
}