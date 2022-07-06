package blackjack

class Dealer {

    private var deck = Deck()
    var hand = Hand()

    fun deal(hand: Hand) {
        if (deck.isEmpty()) {
            deck = Deck()
        }

        hand.cards.add(deck.getTopCard())
    }

    fun payout() {
        TODO("Not yet implemented")
    }

    fun play() {
        TODO("Not yet implemented")
    }
}