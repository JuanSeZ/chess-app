package edu.austral.dissis.common.game

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.piece.Color

interface TurnManager {
    fun nextTurn(move: Move): Color
}
