package blackjack

class Game(val dealer: Dealer = Dealer(), val players: ArrayList<Player> = arrayListOf<Player>()) {

    fun addPlayer(playerName: String) {
        players.add(Player(playerName))
    }

    fun copy(): Game {
        val players: ArrayList<Player> = arrayListOf<Player>()

        for (player in this.players) {
            players.add(player.copy())
        }

        return Game(this.dealer.copy(), players)
    }
}