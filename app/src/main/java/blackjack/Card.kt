package blackjack

class Card(val suite: Suite, val rank: Rank, var faceUp: Boolean = false) {

    val value: Int = rank.value

    override fun toString(): String {
        return "$rank of $suite"
    }
}