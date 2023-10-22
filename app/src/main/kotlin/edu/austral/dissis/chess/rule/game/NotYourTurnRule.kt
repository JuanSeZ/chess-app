package edu.austral.dissis.chess.rule.game

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class NotYourTurnRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (move.turn == move.board.getPieceAt(move.from)?.color) return ValidResult
        return InvalidResult("It's not your turn!")
    }
}
