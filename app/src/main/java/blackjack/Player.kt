package blackjack

class Player(val name: String, var bank: Double = 1000.0, val hands: Array<Hand?> = arrayOfNulls<Hand>(4)) {

    fun placeInitialBet(amount: Int) {
        if (amount < 2 || amount > 500) {
            throw IllegalArgumentException("Not a valid amount")
        }
        hands[0] = Hand(betAmount = amount)
        bank -= amount
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

    fun copy(): Player {
        val hands: Array<Hand?> = arrayOfNulls<Hand>(4)

        for (i in hands.indices) {
            if (this.hands[i] != null) {
                hands[i] = this.hands[i]?.copy()
            }
        }

        return Player(this.name, this.bank, hands)
    }
}