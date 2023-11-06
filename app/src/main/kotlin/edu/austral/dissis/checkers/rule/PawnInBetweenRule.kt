package edu.austral.dissis.checkers.rule

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class PawnInBetweenRule : Rule {

    override fun validate(move: Move): ValidationResult {
        val from = move.from
        val to = move.to

        val rowDirection = if (to.row > from.row) 1 else -1
        val colDirection = if (to.column > from.column) 1 else -1

        var currentRow = from.row + rowDirection
        var currentCol = from.column + colDirection

        while (currentRow != to.row && currentCol != to.column) {
            val currentPosition = Position(currentRow, currentCol)
            val piece = move.board.getPieceAt(currentPosition)

            if (piece != null && piece.color != move.turn) {
                // There is a pawn from the enemy team in between the move.from and move.to
                return ValidResult
            }

            currentRow += rowDirection
            currentCol += colDirection
        }

        // No pawn from the enemy team found in between the move.from and move.to
        return InvalidResult("There is no enemy pawn in between the positions.")
    }
}
