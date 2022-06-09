package com.example.epikgames.wordle

import junit.framework.TestCase.assertEquals
import org.junit.Test
import wordle.Board
import wordle.HEIGHT
import wordle.WIDTH

class BoardTest {

    private val board: Board = Board()

    @Test
    fun typeLetter() {
        board.type('A')
        assertEquals('A', board.tileArray[0].char)
    }

    @Test
    fun typeLetterAtRowEdge() {
        // Initialization
        board.type('C')
        board.type('R')
        board.type('A')
        board.type('N')
        board.type('E')

        board.type('B')

        assertEquals('E', board.tileArray[WIDTH - 1].char)
        assertEquals(' ', board.tileArray[WIDTH].char)

    }

    @Test
    fun typeLetterWithFullBoard() {
        // Initialization
        for (i in 1..(WIDTH * HEIGHT)) {
            board.type('A')
        }

        board.type('A')
    }

}