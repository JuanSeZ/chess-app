package start

import board.Board

interface StartingBoardGenerator {
    fun generate(): Board
}
