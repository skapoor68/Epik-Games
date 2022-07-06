package blackjack

class Game {
    val dealer = Dealer()
    val players = arrayListOf<Player>()

    fun addPlayer(playerName: String) {
        players.add(Player(playerName))
    }
}