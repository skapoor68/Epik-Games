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

    //Colors for letters are based off of https://mywordle.strivemath.com/?word=yoigd
    @Test
    fun guessWordFuncIrons01() {
        //Set wordList to index 2 for word: irons
        val actualColors: ArrayList<String> = arrayListOf()
        actualColors.add("GRAY")
        actualColors.add("YELLOW")
        actualColors.add("GRAY")
        actualColors.add("YELLOW")
        actualColors.add("GRAY")
        val testColorList: ArrayList<String> = board.guess("diary")
        assertEquals(actualColors, testColorList)

    }

    //Test case fails. My code has difficult differentiating between marking duplicate letters as yellow or gray
    @Test
    fun guessWordFuncHello01() {
        //Set wordList to index 0 for word: hello
        val actualColors: ArrayList<String> = arrayListOf()
        actualColors.add("YELLOW")
        actualColors.add("GREEN")
        actualColors.add("GRAY")
        actualColors.add("GRAY")
        actualColors.add("YELLOW")
        val testColorList: ArrayList<String> = board.guess("level")
        assertEquals(actualColors, testColorList)
    }

    @Test
    fun guessWordFuncCards01() {
        //Set wordList to index 1 for word: cards
        val actualColors: ArrayList<String> = arrayListOf()
        actualColors.add("YELLOW")
        actualColors.add("GRAY")
        actualColors.add("YELLOW")
        actualColors.add("GRAY")
        actualColors.add("GREEN")
        val testColorList: ArrayList<String> = board.guess("decks")
        assertEquals(actualColors, testColorList)
    }

}