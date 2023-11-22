package edu.austral.dissis.chess.game

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.game.MoveAction

class ChessCastlingAction: MoveAction {
    override fun appliesTo(move: Move): Boolean {
        return false
    }

    override fun apply(move: Move): Board {
        return move.board.move(move.from, move.to)
    }
}