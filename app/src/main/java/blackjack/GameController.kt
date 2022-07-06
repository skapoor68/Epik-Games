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
}