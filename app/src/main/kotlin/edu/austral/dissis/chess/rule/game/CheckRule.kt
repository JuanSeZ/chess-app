package edu.austral.dissis.chess.rule.game

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule
import edu.austral.dissis.chess.rule.utils.isInCheckAfterMove

class CheckRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if(isInCheckAfterMove(move)) return InvalidResult("It will be in check!")
        return ValidResult
    }
}
