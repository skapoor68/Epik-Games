package blackjack

class Hand(val cards: ArrayList<Card> = arrayListOf(), val betAmount: Int = 0) {
    fun getValue(): Int {
        var total = 0
        var numAces = 0

        for (card in cards) {
            total += card.value
            if (card.rank == Rank.ACE) {
                numAces++
            }
        }

        while (total > 21 && numAces > 0) {
            total -= 10
            numAces -= 1
        }

        return total
    }

    fun copy(): Hand {
        val cards: ArrayList<Card> = arrayListOf()

        for (card in this.cards) {
            cards.add(card)
        }

        return Hand(cards, this.betAmount)
    }
}