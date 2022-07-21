package blackjack

class Game(val dealer: Dealer = Dealer(), val players: ArrayList<Player> = arrayListOf<Player>(),
var currentPlayer: Int = 0) {

    fun addPlayer(playerName: String) {
        players.add(Player(playerName))
    }

    fun moveToNextPlayer(): Boolean {
        if (players.size == 0) {
            throw Exception("Game has no players")
        }

        if (players.size == 1 && getCurrentPlayer()!!.roundOver) {
            return false
        }

        if (players.size > 1) {
            currentPlayer++
            var count = 0

            while (getCurrentPlayer()!!.roundOver && count < players.size) {
                count++
                currentPlayer++
            }

            if (getCurrentPlayer()!!.roundOver) {
                return false
            }
        }

        return true
    }

    fun getCurrentPlayer(): Player? {
        if (players.size > 0) {
            return players[currentPlayer % players.size]
        }

        return null
    }

    fun copy(): Game {
        val players: ArrayList<Player> = arrayListOf<Player>()

        for (player in this.players) {
            players.add(player.copy())
        }

        return Game(this.dealer.copy(), players, this.currentPlayer)
    }
}