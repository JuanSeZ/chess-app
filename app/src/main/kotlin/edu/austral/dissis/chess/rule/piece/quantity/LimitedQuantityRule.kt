package rule.piece.quantity

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class LimitedQuantityRule(private val quantity : Int) : Rule {
    override fun validate(move: Move): ValidationResult {
        if( move.to.x - move.from.x == quantity || move.to.y - move.from.y == quantity) return ValidResult
        return InvalidResult()
    }
}
