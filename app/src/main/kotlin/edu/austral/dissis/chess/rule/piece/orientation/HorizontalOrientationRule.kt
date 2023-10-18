package rule.piece.orientation

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class HorizontalOrientationRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (move.from.x == move.to.x) return ValidResult
        return InvalidResult()
    }
}
