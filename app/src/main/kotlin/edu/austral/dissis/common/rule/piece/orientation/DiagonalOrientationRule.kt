package edu.austral.dissis.common.rule.piece.orientation

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule
import kotlin.math.abs

class DiagonalOrientationRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if(abs(move.from.column - move.to.column) == abs(move.from.row - move.to.row)) return ValidResult
        return InvalidResult("You can't move diagonally!")
    }
}
