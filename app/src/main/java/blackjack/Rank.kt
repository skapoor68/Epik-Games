package blackjack

enum class Rank {
    TWO {
        override fun toString(): String {
            return "Two"
        }
        },
    THREE{
        override fun toString(): String {
            return "Three"
        }
    },
    FOUR{
        override fun toString(): String {
            return "Four"
        }
    },
    FIVE{
        override fun toString(): String {
            return "Five"
        }
    },
    SIX{
        override fun toString(): String {
            return "Six"
        }
    },
    SEVEN{
        override fun toString(): String {
            return "Seven"
        }
    },
    EIGHT{
        override fun toString(): String {
            return "Eight"
        }
    },
    NINE{
        override fun toString(): String {
            return "Nine"
        }
    },
    TEN{
        override fun toString(): String {
            return "Ten"
        }
    },
    JACK{
        override fun toString(): String {
            return "Jack"
        }
    },
    QUEEN{
        override fun toString(): String {
            return "Queen"
        }
    },
    KING{
        override fun toString(): String {
            return "King"
        }
    },
    ACE{
        override fun toString(): String {
            return "Ace"
        }
    }
}