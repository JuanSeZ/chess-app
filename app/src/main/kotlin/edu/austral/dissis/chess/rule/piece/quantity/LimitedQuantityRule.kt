package edu.austral.dissis.chess.rule.piece.quantity

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule
import kotlin.math.abs

class LimitedQuantityRule(private val quantity : Int) : Rule {
    override fun validate(move: Move): ValidationResult {
        if( abs(move.to.column - move.from.column) == quantity || abs(move.to.row - move.from.row) == quantity) return ValidResult
        return InvalidResult("You can't move that far!")
    }
}
