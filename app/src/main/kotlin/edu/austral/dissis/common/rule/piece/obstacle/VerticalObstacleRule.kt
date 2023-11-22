package edu.austral.dissis.common.rule.piece.obstacle

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class VerticalObstacleRule : Rule {
    override fun validate(move: Move): ValidationResult {
        val (start, end) = if (move.from.row > move.to.row) {
            move.to.row + 1 to move.from.row
        } else {
            move.from.row + 1 to move.to.row
        }
        for (i in start until end) {
            if (hasAPieceInTheWay(move, i)) {
                return InvalidResult("There is a piece in the way!")
            }
        }
        return ValidResult
    }

    private fun hasAPieceInTheWay(move: Move, i: Int) =
        move.board.getPieceAt(move.from.copy(row = i)) != null
}
