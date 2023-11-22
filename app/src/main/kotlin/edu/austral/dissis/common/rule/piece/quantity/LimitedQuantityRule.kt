package edu.austral.dissis.common.rule.piece.quantity

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule
import kotlin.math.abs

class LimitedQuantityRule(private val quantity : Int) : Rule {
    override fun validate(move: Move): ValidationResult {
        if(isInRange(move)) return ValidResult
        return InvalidResult("You can't move that far!")
    }

    private fun isInRange(move: Move) =
        abs(move.to.column - move.from.column) == quantity || abs(move.to.row - move.from.row) == quantity
}
