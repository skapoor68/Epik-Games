package blackjack

class Hand(val cards: ArrayList<Card> = arrayListOf(), val betAmount: Int = 0) {
    fun getValue(): Int {
        var total = 0

        for (card in cards) {
            total += card.value
        }

        return total
    }
}