package edu.austral.dissis.common.start

import edu.austral.dissis.common.board.Board

interface StartingBoardGenerator {
    fun generate(): Board
}
