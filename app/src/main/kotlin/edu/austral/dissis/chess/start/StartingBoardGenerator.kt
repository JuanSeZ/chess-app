package start

import edu.austral.dissis.chess.board.Board

interface StartingBoardGenerator {
    fun generate(): Board
}
