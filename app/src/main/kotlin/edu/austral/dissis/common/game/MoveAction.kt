package edu.austral.dissis.common.game

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move

interface MoveAction {
    fun appliesTo(move: Move): Boolean
    fun apply(move: Move): Board
}
