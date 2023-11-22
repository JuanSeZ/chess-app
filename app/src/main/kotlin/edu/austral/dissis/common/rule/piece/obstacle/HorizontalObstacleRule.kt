package edu.austral.dissis.common.rule.piece.obstacle

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class HorizontalObstacleRule : Rule {
    override fun validate(move: Move): ValidationResult {
        val (start, end) = if (move.from.column > move.to.column) {
            move.to.column + 1 to move.from.column
        } else {
            move.from.column + 1 to move.to.column
        }
        for (i in start until end) {
            if (isThereIsAPieceBetween(move, i)) {
                return InvalidResult("There is a piece in the way!")
            }
        }
        return ValidResult
    }

    private fun isThereIsAPieceBetween(move: Move, i: Int) =
        move.board.getPieceAt(move.from.copy(column = i)) != null
}
