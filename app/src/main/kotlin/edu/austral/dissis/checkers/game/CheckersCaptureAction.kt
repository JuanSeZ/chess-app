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

        val rowDirection = if (rowIsBigger(to, from)) 1 else -1
        val colDirection = if (columnIsBigger(to, from)) 1 else -1

        var currentRow = from.row + rowDirection
        var currentCol = from.column + colDirection

        val currentPosition = Position(currentCol, currentRow)

        return move.board.move(move.from, move.to).removePiece(currentPosition)
    }

    private fun columnIsBigger(
        to: Position,
        from: Position
    ) = to.column > from.column

    private fun rowIsBigger(
        to: Position,
        from: Position
    ) = to.row > from.row
}
