package blackjack

enum class Suite {
    HEART {
        override fun toString(): String {
            return "Hearts"
        }},
    SPADE{
        override fun toString(): String {
            return "Spades"
        }},
    CLUB{
        override fun toString(): String {
            return "Clubs"
        }},
    DIAMOND{
        override fun toString(): String {
            return "Diamonds"
        }}
}