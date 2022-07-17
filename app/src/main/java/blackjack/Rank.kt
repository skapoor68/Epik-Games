package blackjack

enum class Rank(val value: Int) {

    TWO(2) {
        override fun toString(): String {
            return "Two"
        }
        },
    THREE(3){

        override fun toString(): String {
            return "Three"
        }
    },
    FOUR(4){

        override fun toString(): String {
            return "Four"
        }
    },
    FIVE(5){

        override fun toString(): String {
            return "Five"
        }
    },
    SIX(6){

        override fun toString(): String {
            return "Six"
        }
    },
    SEVEN(7){

        override fun toString(): String {
            return "Seven"
        }
    },
    EIGHT(8){

        override fun toString(): String {
            return "Eight"
        }
    },
    NINE(9){

        override fun toString(): String {
            return "Nine"
        }
    },
    TEN(10){

        override fun toString(): String {
            return "Ten"
        }
    },
    JACK(10){

        override fun toString(): String {
            return "Jack"
        }
    },
    QUEEN(10){

        override fun toString(): String {
            return "Queen"
        }
    },
    KING(10){

        override fun toString(): String {
            return "King"
        }
    },
    ACE(11){

        override fun toString(): String {
            return "Ace"
        }
    };
}