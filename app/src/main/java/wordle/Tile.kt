package wordle


class Tile(val id: Int, val char: Char = ' ', var color: Int = 0) {

    override fun toString(): String {
        return "$id, $char, $color"
    }

}