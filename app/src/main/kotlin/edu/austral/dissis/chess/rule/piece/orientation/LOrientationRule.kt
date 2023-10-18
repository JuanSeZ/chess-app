package rule.piece.orientation

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule
import kotlin.math.abs

class LOrientationRule : Rule {
    override fun validate(move: Move): ValidationResult {
        val xDiff = abs(move.from.x - move.to.x)
        val yDiff = abs(move.from.y - move.to.y)
        if ((xDiff == 1 && yDiff == 2) || (xDiff == 2 && yDiff == 1)) return ValidResult
        return InvalidResult()
    }
}
