package edu.austral.dissis.chess.rule.piece

import edu.austral.dissis.chess.board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class HasNotEnemyRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (move.board.getPieceAt(move.to) != null) return InvalidResult("You can't eat vertically!")
        return ValidResult
    }

}
