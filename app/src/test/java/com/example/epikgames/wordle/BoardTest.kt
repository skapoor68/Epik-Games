package com.example.epikgames.wordle

import android.graphics.Color
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertArrayEquals
import org.junit.Test
import wordle.*

class BoardTest {

    private val board = Board(solution = "DECKS")

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

    @Test
    fun canGuessTest() {
        board.type('C')
        board.type('R')
        board.type('A')
        board.type('N')

        assertEquals(false, board.canGuess())
        board.type('E')
        assertEquals(true, board.canGuess())
    }

    @Test
    fun typeIntoLastTile() {
        board.type('A')
        board.type('A')
        board.type('B')
        board.type('B')
        board.type('B')

        board.guess()

        board.type('C')
        board.type('C')
        board.type('C')
        board.type('C')
        board.type('C')

        board.guess()

        board.type('D')
        board.type('D')
        board.type('D')
        board.type('D')
        board.type('D')

        board.guess()

        board.type('T')
        board.type('T')
        board.type('T')
        board.type('D')
        board.type('D')

        board.guess()

        board.type('E')
        board.type('E')
        board.type('E')
        board.type('E')
        board.type('E')

        board.guess()

        board.type('F')
        board.type('G')
        board.type('H')
        board.type('I')
        board.type('J')

        assertEquals('J', board.tileArray[WIDTH * HEIGHT - 1].char)
    }


    //Colors for letters are based off of https://mywordle.strivemath.com/?word=yoigd
    @Test
    fun guessWordFuncIrons01() {
        val board = Board(solution = "IRONS")

        val actualColors: Array<Tile> = Array(30) { i -> Tile(i) }

        actualColors[0] = Tile(0, 'D', BoardColor.DARK_GRAY)
        actualColors[1] = Tile(1, 'I', BoardColor.YELLOW)
        actualColors[2] = Tile(2, 'A', BoardColor.DARK_GRAY)
        actualColors[3] = Tile(3, 'R', BoardColor.YELLOW)
        actualColors[5] = Tile(4, 'Y', BoardColor.DARK_GRAY)

        board.type('D')
        board.type('I')
        board.type('A')
        board.type('R')
        board.type('Y')

        board.guess()

        val actualLetterStatus = Array(26) { _ -> -1}
        actualLetterStatus['D'.code - 65] = 0
        actualLetterStatus['I'.code - 65] = 1
        actualLetterStatus['A'.code - 65] = 0
        actualLetterStatus['R'.code - 65] = 1
        actualLetterStatus['Y'.code - 65] = 0

        assertArrayEquals(actualLetterStatus, board.letterStatus)
    }

    @Test
    fun guessWordFuncHello01() {
        val board = Board(solution = "HELLO")

        val actualColors: Array<Tile> = Array(30) { i -> Tile(i) }

        actualColors[0] = Tile(0, 'L', BoardColor.YELLOW)
        actualColors[1] = Tile(1, 'E', BoardColor.GREEN)
        actualColors[2] = Tile(2, 'V', BoardColor.DARK_GRAY)
        actualColors[3] = Tile(3, 'E', BoardColor.YELLOW)
        actualColors[4] = Tile(4, 'L', BoardColor.YELLOW)

        board.type('L')
        board.type('E')
        board.type('V')
        board.type('E')
        board.type('L')
        board.guess()

        assertArrayEquals(actualColors, board.tileArray)

        val actualLetterStatus = Array(26) { _ -> -1}
        actualLetterStatus['L'.code - 65] = 1
        actualLetterStatus['E'.code - 65] = 2
        actualLetterStatus['V'.code - 65] = 0

        assertArrayEquals(actualLetterStatus, board.letterStatus)
    }

    @Test
    fun guessWordFuncCards01() {
        val board = Board(solution = "CARDS")

        val actualColors: Array<Tile> = Array(30) { i -> Tile(i) }

        actualColors[0] = Tile(0, 'D', BoardColor.YELLOW)
        actualColors[1] = Tile(1, 'E', BoardColor.DARK_GRAY)
        actualColors[2] = Tile(2, 'C', BoardColor.YELLOW)
        actualColors[3] = Tile(3, 'K', BoardColor.DARK_GRAY)
        actualColors[4] = Tile(4, 'S', BoardColor.GREEN)

        board.type('D')
        board.type('E')
        board.type('C')
        board.type('K')
        board.type('S')
        board.guess()


        assertArrayEquals(actualColors, board.tileArray)

        val actualLetterStatus = Array(26) { _ -> -1}
        actualLetterStatus['D'.code - 65] = 1
        actualLetterStatus['E'.code - 65] = 0
        actualLetterStatus['C'.code - 65] = 1
        actualLetterStatus['K'.code - 65] = 0
        actualLetterStatus['S'.code - 65] = 2

        assertArrayEquals(actualLetterStatus, board.letterStatus)
    }
}