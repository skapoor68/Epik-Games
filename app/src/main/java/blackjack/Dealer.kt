package blackjack

class Dealer(private var deck: Deck = Deck(), var hand: Hand = Hand()) {

    fun deal(hand: Hand, faceUp: Boolean = true) {
        if (deck.isEmpty()) {
            deck = Deck()
        }

        val card: Card = deck.getTopCard()
        card.faceUp = true

        hand.cards.add(deck.getTopCard())
    }

    fun payout() {
        TODO("Not yet implemented")
    }

    fun play() {
        TODO("Not yet implemented")
    }

    fun settle(player: Player, betAmount: Double, handNumber: Int) {
        player.bank += betAmount
        player.hands[handNumber] = null
    }

    fun copy(): Dealer {
        return Dealer(deck.copy(), hand.copy())
    }
}