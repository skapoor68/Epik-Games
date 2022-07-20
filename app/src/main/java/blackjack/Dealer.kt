package blackjack

class Dealer(private var deck: Deck = Deck(), var hand: Hand = Hand()) {

    fun deal(hand: Hand, faceUp: Boolean = true) : Card {
        if (deck.isEmpty()) {
            deck = Deck()
        }

        val card: Card = deck.getTopCard()
        card.faceUp = true

        hand.cards.add(deck.getTopCard())
        return deck.getTopCard()
    }

    fun payout() {
        TODO("Not yet implemented")
    }

    fun play() {
        //Dealer turns card that is face down face up
        var totalVal = 0
        for (c in hand.cards) {
            if (!c.faceUp) {
                c.faceUp = true
            }
            totalVal += c.value
        }

        while (totalVal < 16) {
            val c: Card = deal(hand)
            totalVal += c.value
        }

        stand()


        //Check total of current hand
        //If hand is below 16, keep drawing
        //If hand is at least 17, stand

    }

    fun settle(player: Player, betAmount: Double, hand: Hand) {
        player.bank += betAmount
        player.hands.remove(hand)
    }

    fun copy(): Dealer {
        return Dealer(deck.copy(), hand.copy())
    }

}