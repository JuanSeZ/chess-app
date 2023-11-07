package edu.austral.dissis.chess.game

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.game.TurnManager
import edu.austral.dissis.common.piece.Color

class ChessTurnManager: TurnManager {
    override fun nextTurn(moves: List<Move>): Color {
        if (moves.last().turn == Color.WHITE)
            return Color.BLACK
        return Color.WHITE
    }


}
