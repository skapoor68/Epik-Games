package wordle

const val HEIGHT = 6
const val WIDTH = 5

class Board(val tileArray: Array<Tile> = Array(HEIGHT * WIDTH) { i -> Tile(i) }) {
    private var curTile = 0

    fun guess() {
        TODO("Not yet implemented")
    }

    fun delete() {
        TODO("Not yet implemented")
    }

    fun type(char: Char) {
        if (curTile >= tileArray.size - 1) {
            return
        }

        if (curTile % WIDTH == (WIDTH - 1)) {
            if (tileArray[curTile].char == ' ') {
                tileArray[curTile] = Tile(tileArray[curTile].id, char)
            }
            return
        }

        tileArray[curTile] = Tile(tileArray[curTile].id, char)
        curTile++
    }

    fun getRow(): Int {
        return curTile / WIDTH
    }

}