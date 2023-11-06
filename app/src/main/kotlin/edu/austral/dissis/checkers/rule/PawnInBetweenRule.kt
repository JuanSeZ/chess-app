package edu.austral.dissis.checkers.rule

import edu.austral.dissis.checkers.utils.isCapture
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class PawnInBetweenRule : Rule {

    override fun validate(move: Move): ValidationResult {
        if (isCapture(move)) {
            return ValidResult
        }
        return InvalidResult("You must capture a piece")
    }
}
