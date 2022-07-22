package blackjack

class Player(val name: String, var bank: Double = 1000.0, val hands: ArrayList<Hand> = arrayListOf<Hand>(),
var roundOver: Boolean = false) {

    fun placeInitialBet(amount: Int) {
        if (amount < 2 || amount > 500) {
            throw IllegalArgumentException("Not a valid amount")
        }
        hands.add(Hand(betAmount = amount))
        bank -= amount
    }

    fun stand() {
        roundOver = true
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

    fun copy(): Player {
        val hands: ArrayList<Hand> = arrayListOf<Hand>()

        for (hand in this.hands) {
            hands.add(hand.copy())
        }

        return Player(this.name, this.bank, hands)
    }
}