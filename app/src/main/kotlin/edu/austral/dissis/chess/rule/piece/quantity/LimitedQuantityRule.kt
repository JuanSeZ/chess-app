package edu.austral.dissis.chess.rule.piece.quantity

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule
import kotlin.math.abs

class LimitedQuantityRule(private val quantity : Int) : Rule {
    override fun validate(move: Move): ValidationResult {
        if( abs(move.to.column - move.from.column) == quantity || abs(move.to.row - move.from.row) == quantity) return ValidResult
        return InvalidResult("You can't move that far!")
    }
}
