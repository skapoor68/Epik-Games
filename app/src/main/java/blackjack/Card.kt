package blackjack

class Card(val suite: Suite, val rank: Rank, val faceUp: Boolean = false) {

    override fun toString(): String {
        return "$rank of $suite"
    }
}