package edu.austral.dissis.chess.rule.game

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule
import edu.austral.dissis.chess.rule.utils.isInCheck
import edu.austral.dissis.chess.rule.utils.isInCheckAfterMove

class CheckRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if(isInCheckAfterMove(move)) return InvalidResult("It will be in check!")
        return ValidResult
    }
}
