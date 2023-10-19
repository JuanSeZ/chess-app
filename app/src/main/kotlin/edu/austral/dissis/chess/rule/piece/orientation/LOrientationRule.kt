package edu.austral.dissis.chess.rule.piece.orientation

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule
import kotlin.math.abs

class LOrientationRule : Rule {
    override fun validate(move: Move): ValidationResult {
        val xDiff = abs(move.from.column - move.to.column)
        val yDiff = abs(move.from.row - move.to.row)
        if ((xDiff == 1 && yDiff == 2) || (xDiff == 2 && yDiff == 1)) return ValidResult
        return InvalidResult("L orientation rule violated!")
    }
}
