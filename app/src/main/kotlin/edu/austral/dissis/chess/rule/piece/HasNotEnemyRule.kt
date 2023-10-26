package edu.austral.dissis.chess.rule.piece

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class HasNotEnemyRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (move.board.getPieceAt(move.to) != null) return InvalidResult("You can't eat vertically!")
        return ValidResult
    }

}
