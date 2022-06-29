package wordle


class Tile(val id: Int, val char: Char = ' ', var color: BoardColor = BoardColor.WHITE) {

    override fun toString(): String {
        return "$id, $char, $color"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Tile) {
            return this.id == other.id && this.char == other.char && this.color == other.color
        }
        return false
    }
}