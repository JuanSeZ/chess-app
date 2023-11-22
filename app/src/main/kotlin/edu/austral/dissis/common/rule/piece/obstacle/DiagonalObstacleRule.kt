package edu.austral.dissis.common.rule.piece.obstacle

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule
import kotlin.math.abs

class DiagonalObstacleRule: Rule {
    override fun validate(move: Move): ValidationResult {
        val (start, end) = if (move.from.column > move.to.column) {
            move.to.column + 1 to move.from.column
        } else {
            move.from.column + 1 to move.to.column
        }
        val (startY, endY) = if (move.from.row > move.to.row) {
            move.to.row + 1 to move.from.row
        } else {
            move.from.row + 1 to move.to.row
        }
        for (i in start until end) {
            if (hasAPieceInBetween(startY, endY, move, i)) return InvalidResult("There is a piece in the way!")
        }
        return ValidResult
    }

    private fun hasAPieceInBetween(
        startY: Int,
        endY: Int,
        move: Move,
        i: Int
    ): Boolean {
        for (j in startY until endY) {
            if (isThereIsAPieceInBetween(move, i, j)) {
                return true
            }
        }
        return false
    }

    private fun isThereIsAPieceInBetween(move: Move, i: Int, j: Int) =
        (move.board.getPieceAt(
            move.from.copy(
                column = i,
                row = j
            )
        ) != null) && abs(i - move.to.column) == abs(j - move.to.row)
}
