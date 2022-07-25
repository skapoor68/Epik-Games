package com.example.epikgames.blackjack

import blackjack.GameController
import blackjack.GameTransition
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class GameControllerTest {
    private val controller = GameController()


    @Test
    fun dealFirstRound() {
        val game = controller.initGame("Player 1", "Player 2", "Player 3")

        for (player in game.players) {
            controller.placeBet(player, 10)
        }

        assertEquals(10, game.players[0].hands[0].betAmount)

        val transitionQueue: Queue<GameTransition> = LinkedList()

        controller.dealFirstRound(game, transitionQueue)

        assertEquals(2, game.players[0].hands[0].cards.size)
        println(game.players[0].hands[0].cards)
    }

    @Test
    fun stand() {
        val game = controller.initGame("Player 1", "Player 2", "Player 3")

        for (player in game.players) {
            controller.placeBet(player, 10)
        }

        val transitionQueue: Queue<GameTransition> = LinkedList()

        controller.stand(game)

        assertEquals(game.players.size, 3)
        assertEquals(true, game.players[0].roundOver)
        assertEquals("Player 2", game.getCurrentPlayer()?.name)
    }

    @Test
    fun roundOverForPlayers() {
        val game = controller.initGame("Player 1", "Player 2", "Player 3")

        for (player in game.players) {
            controller.placeBet(player, 10)
        }
        controller.roundOverForPlayers(game)

        assertEquals(false, game.players[0].roundOver)
        assertEquals(false, game.players[1].roundOver)
        assertEquals(false, game.players[2].roundOver)

        controller.stand(game)

        assertEquals(true, game.players[0].roundOver)
    }

    @Test
    fun hit() {
        val game = controller.initGame("Player 1", "Player 2", "Player 3")

        val transitionQueue: Queue<GameTransition> = LinkedList()
        for (player in game.players) {
            controller.placeBet(player, 10)
        }
        controller.hit(game, transitionQueue)
        assertEquals(game.players[0], game.getCurrentPlayer())
        assertEquals(1, game.players[0].hands.size)

    }
}