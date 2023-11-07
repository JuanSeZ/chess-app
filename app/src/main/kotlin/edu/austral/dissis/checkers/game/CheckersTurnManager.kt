package edu.austral.dissis.checkers.game

import edu.austral.dissis.checkers.utils.isCapture
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.game.TurnManager
import edu.austral.dissis.common.piece.Color

class CheckersTurnManager : TurnManager {
    override fun nextTurn(moves: List<Move>): Color {
        if(isCapture(moves.last()))
            return moves.last().turn

        if (moves.last().turn == Color.WHITE)
            return Color.BLACK

        return Color.WHITE
    }
}
