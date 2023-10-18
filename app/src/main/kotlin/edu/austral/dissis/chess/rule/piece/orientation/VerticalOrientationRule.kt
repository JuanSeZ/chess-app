package rule.piece.orientation

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class VerticalOrientationRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (move.from.y == move.to.y) return ValidResult
        return InvalidResult()
    }
}
