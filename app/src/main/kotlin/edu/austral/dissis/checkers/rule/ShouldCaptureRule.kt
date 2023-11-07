package edu.austral.dissis.checkers.rule

import edu.austral.dissis.checkers.utils.isCapture
import edu.austral.dissis.checkers.utils.isPossibleToCapture
import edu.austral.dissis.checkers.utils.lastMoveWasCapture
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class ShouldCaptureRule: Rule {



    override fun validate(move: Move): ValidationResult {
        if (move.history.isNotEmpty() && lastMoveWasCapture(move) && isPossibleToCapture(move) && !isCapture(move)) {
            return InvalidResult("You must capture a piece")
        }
        return ValidResult
    }
}
