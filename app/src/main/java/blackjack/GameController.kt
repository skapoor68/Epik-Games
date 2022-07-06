package blackjack

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

    fun dealFirstRound(game: Game) {

        for (player in game.players) {
            if (player.hands[0] == null) {
                throw NullPointerException("Hand does not exist")
            }
        }

        TODO("Create a transition after every card deal and return a transition list so " +
                "that the GUI doesn't update immediately")
        for (i in 1..2) {
            for (player in game.players) {
                val hand: Hand = player.hands[0]!!
                game.dealer.deal(hand)
            }
        }

    }
}