package blackjack

class Card(val suite: Suite, val rank: Rank, var faceUp: Boolean = false) {

    val value: Int = rank.value

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