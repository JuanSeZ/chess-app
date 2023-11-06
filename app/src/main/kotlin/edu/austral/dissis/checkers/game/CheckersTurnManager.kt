package edu.austral.dissis.checkers.game

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.game.TurnManager
import edu.austral.dissis.common.piece.Color

class CheckersTurnManager : TurnManager {
    override fun nextTurn(move: Move): Color {
        return if (move.turn == Color.WHITE) Color.BLACK else Color.WHITE
    }
}
