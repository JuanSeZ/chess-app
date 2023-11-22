package edu.austral.dissis.checkers.rule

import edu.austral.dissis.checkers.utils.*
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class ShouldCaptureRule : Rule {

    override fun validate(move: Move): ValidationResult {
        if (move.history.isEmpty() || !lastMoveWasCapture(move) || !isPossibleToCaptureAgain(move)) {
            return ValidResult
        }

        if (!isCapture(move)) {
            return InvalidResult("You must capture a piece")
        }

        return if (isTheSamePiece(move)) ValidResult else InvalidResult("You must capture with the same piece")
    }
}
