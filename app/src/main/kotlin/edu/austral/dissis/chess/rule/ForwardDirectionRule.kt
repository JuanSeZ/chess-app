package edu.austral.dissis.chess.rule

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import piece.Color
import result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class ForwardDirectionRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (move.turn == Color.WHITE && move.from.row > move.to.row) return ValidResult
        if (move.turn == Color.BLACK && move.from.row < move.to.row) return ValidResult
        return InvalidResult("Piece can't move backwards")

    }
}
