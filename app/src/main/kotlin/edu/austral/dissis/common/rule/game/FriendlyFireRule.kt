package edu.austral.dissis.common.rule.game

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class FriendlyFireRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (move.board.getPieceAt(move.to)?.color != move.board.getPieceAt(move.from)?.color) return ValidResult
        return InvalidResult("You can't eat your own pieces!")
    }
}
