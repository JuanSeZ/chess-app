package edu.austral.dissis.common.rule.piece.orientation

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule
import kotlin.math.abs

class LOrientationRule : Rule {
    override fun validate(move: Move): ValidationResult {
        val xDiff = abs(move.from.column - move.to.column)
        val yDiff = abs(move.from.row - move.to.row)
        if (isInRange(xDiff, yDiff)) return ValidResult
        return InvalidResult("L orientation rule violated!")
    }

    private fun isInRange(xDiff: Int, yDiff: Int) = (xDiff == 1 && yDiff == 2) || (xDiff == 2 && yDiff == 1)
}
