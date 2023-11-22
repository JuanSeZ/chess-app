package edu.austral.dissis.chess.game

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.game.TurnManager
import edu.austral.dissis.common.piece.Color

class ChessTurnManager: TurnManager {
    override fun nextTurn(moves: List<Move>): Color {
        if (lastTurnWasWhite(moves))
            return Color.BLACK
        return Color.WHITE
    }

    private fun lastTurnWasWhite(moves: List<Move>) = moves.last().turn == Color.WHITE


}
