package edu.austral.dissis.chess.rule.piece.orientation

import edu.austral.dissis.chess.board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule
import kotlin.math.abs

class DiagonalOrientationRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if(abs(move.from.column - move.to.column) == abs(move.from.row - move.to.row)) return ValidResult
        return InvalidResult("You can't move diagonally!")
    }
}
