package edu.austral.dissis.common.rule.piece

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class ForwardDirectionRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (isMovingForward(move)) return ValidResult
        return InvalidResult("Piece can't move backwards")

    }

    private fun isMovingForward(move: Move) = (move.turn == Color.WHITE && move.from.row > move.to.row) || (move.turn == Color.BLACK && move.from.row < move.to.row)
}
