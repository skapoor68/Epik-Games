package com.example.epikgames.wordle

import junit.framework.TestCase.assertNotSame
import org.junit.Test
import junit.framework.TestCase.assertEquals

import wordle.*

class WordsListTest {
    private val boardC: BoardController = BoardController()
    private val board1 = Board(solution = boardC.getRandWord())
    private val board2 = Board(solution = boardC.getRandWord())

    @Test
    fun wordListSize() {
        assertEquals(2309, boardC.getWords().size)
    }

    @Test
    fun randomWord() {
        assertNotSame(board1.solution, board2.solution)
    }


}