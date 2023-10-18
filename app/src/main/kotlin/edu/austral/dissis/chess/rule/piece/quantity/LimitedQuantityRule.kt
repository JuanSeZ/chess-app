package rule.piece.quantity

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class LimitedQuantityRule(private val quantity : Int) : Rule {
    override fun validate(move: Move): ValidationResult {
        if( move.to.column - move.from.column == quantity || move.to.row - move.from.row == quantity) return ValidResult
        return InvalidResult()
    }
}
