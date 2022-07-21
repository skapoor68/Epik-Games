package blackjack

import java.lang.IllegalArgumentException
import java.util.*

class GameController {

    fun initGame(vararg playerName: String): Game {
        val game = Game()

        for (name in playerName) {
            game.addPlayer(name)
        }

        return game
    }

    fun placeBet(player: Player, amount: Int) {
        player.placeInitialBet(amount)
    }

    fun dealFirstRound(game: Game, transitionQueue: Queue<GameTransition>) {

        for (player in game.players) {
            if (player.hands.size == 0) {
                throw NullPointerException("Hand does not exist")
            }

            if (player.hands[0].cards.size > 0) {
                throw IllegalArgumentException("First round has already been dealt")
            }
        }

        for (i in 1..2) {
            for (player in game.players) {
                val hand: Hand = player.hands[0]
                game.dealer.deal(hand)
                transitionQueue.add(DealTransition(game.copy()))
            }
            game.dealer.deal(game.dealer.hand, i % 2 == 1)
            transitionQueue.add(DealTransition(game.copy()))
        }

        if (game.dealer.hand.cards[0].value == 10 || game.dealer.hand.cards[0].value == 11
            && game.dealer.hand.getValue() == 21) {
            for (player in game.players) {
                if (player.hands[0].getValue() == 21) {
                    game.dealer.settle(player, player.hands[0].betAmount.toDouble(), player.hands[0])
                }
                transitionQueue.add(SettlementTransition(game.copy()))
            }
            return
        }

        for (player in game.players) {
            if (player.hands[0].getValue() == 21) {
                game.dealer.settle(player, 2.5 * player.hands[0].betAmount, player.hands[0])
                transitionQueue.add(SettlementTransition(game.copy()))
            }
        }

    }

    fun stand(game: Game): Boolean {
        if (game.getCurrentPlayer() == null) {
            throw IllegalArgumentException("Game has no players")
        }

        game.getCurrentPlayer()!!.stand()

        return game.moveToNextPlayer()
    }

}