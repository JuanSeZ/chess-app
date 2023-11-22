package edu.austral.dissis.common.rule.piece

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class FirstMoveRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (hasMoveAlready(move)) return InvalidResult("You can't move this piece!")
        return ValidResult
    }

    private fun hasMoveAlready(move: Move) = move.board.getPieceAt(move.from)?.getMoveCount()!! > 0
}
