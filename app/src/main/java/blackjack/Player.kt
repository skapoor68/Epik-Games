package blackjack

class Player(val name: String) {

    val hands = arrayOfNulls<Hand>(4)

    fun placeInitialBet(amount: Int) {
        hands[0] = Hand(betAmount = amount)
    }

    fun stand() {
        TODO("Not yet implemented")
    }

    fun hit() {
        TODO("Not yet implemented")
    }

    fun split() {
        TODO("Not yet implemented")
    }

    fun doubleDown() {
        TODO("Not yet implemented")
    }
}