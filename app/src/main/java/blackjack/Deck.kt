package blackjack

class Deck(private val cards: ArrayList<Card> = (ArrayList(List(52){ Card(Suite.values()[it % 4], Rank.values()[it / 4])}))) {

    init {
        cards.shuffle()
    }

    fun getTopCard(): Card {
        return cards.removeFirst()
    }

    fun isEmpty(): Boolean {
        return cards.isEmpty()
    }

    fun copy(): Deck {
        val cards: ArrayList<Card> = arrayListOf()

        for (card in this.cards) {
            cards.add(card)
        }

        return Deck(cards)
    }

}