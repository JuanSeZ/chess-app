package edu.austral.dissis.checkers.game

import edu.austral.dissis.checkers.utils.isCapture
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.MoveAction

class CheckersCaptureAction : MoveAction {
    override fun appliesTo(move: Move): Boolean {
        return isCapture(move)
    }

    override fun apply(move: Move): Board {
        val from = move.from
        val to = move.to

        val rowDirection = if (to.row > from.row) 1 else -1
        val colDirection = if (to.column > from.column) 1 else -1

        var currentRow = from.row + rowDirection
        var currentCol = from.column + colDirection

        val currentPosition = Position(currentCol, currentRow)

        return move.board.move(move.from, move.to).removePiece(currentPosition)
    }
}
