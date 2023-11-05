package edu.austral.dissis.chess.game

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.game.TurnManager
import edu.austral.dissis.common.piece.Color

class ChessTurnManager: TurnManager {
    override fun nextTurn(move: Move): Color {
        move.board.getBoard()[move.from]?.let {
            if(it.color == Color.WHITE) {
                return Color.BLACK
            }
        }
        return Color.WHITE
    }


}
