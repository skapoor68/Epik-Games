package blackjack


class Card(val suite: Suite, val rank: Rank, val faceUp: Boolean = false) {

    val value: Int = rank.value
    val image: Int? = CardImages.getCardResource(suite, rank)

    override fun toString(): String {
        return "$rank of $suite"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Card) {
            return false
        }

        return other.suite == suite && other.rank == rank && other.faceUp == faceUp
    }
}