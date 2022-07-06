package com.example.epikgames.blackjack

import blackjack.GameController
import org.junit.Assert.assertEquals
import org.junit.Test

class GameControllerTest {
    private val controller = GameController()


    @Test
    fun dealFirstRound() {
        val game = controller.initGame("Player 1", "Player 2", "Player 3")

        for (player in game.players) {
            controller.placeBet(player, 10)
        }

        assertEquals(10, game.players[0].hands[0]?.betAmount)

        controller.dealFirstRound(game)

        assertEquals(2, game.players[0].hands[0]?.cards?.size)
        println(game.players[0].hands[0]?.cards)
    }
}