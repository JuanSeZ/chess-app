package edu.austral.dissis.chess.rule.piece

import edu.austral.dissis.chess.board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class FirstMoveRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (move.board.getPieceAt(move.from)?.getMoveCount()!! > 0) return InvalidResult("You can't move this piece!")
        return ValidResult
    }
}
