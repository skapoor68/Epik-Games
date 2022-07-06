package blackjack

enum class Rank {

    TWO {
        val value = 2
        override fun toString(): String {
            return "Two"
        }
        },
    THREE{
        val value = 3
        override fun toString(): String {
            return "Three"
        }
    },
    FOUR{
        val value = 4
        override fun toString(): String {
            return "Four"
        }
    },
    FIVE{
        val value = 5
        override fun toString(): String {
            return "Five"
        }
    },
    SIX{
        val value = 6
        override fun toString(): String {
            return "Six"
        }
    },
    SEVEN{
        val value = 7
        override fun toString(): String {
            return "Seven"
        }
    },
    EIGHT{
        val value = 8
        override fun toString(): String {
            return "Eight"
        }
    },
    NINE{
        val value = 9
        override fun toString(): String {
            return "Nine"
        }
    },
    TEN{
        val value = 10
        override fun toString(): String {
            return "Ten"
        }
    },
    JACK{
        val value = 10
        override fun toString(): String {
            return "Jack"
        }
    },
    QUEEN{
        val value = 10
        override fun toString(): String {
            return "Queen"
        }
    },
    KING{
        val value = 10
        override fun toString(): String {
            return "King"
        }
    },
    ACE{
        val value = 11
        override fun toString(): String {
            return "Ace"
        }
    };
}