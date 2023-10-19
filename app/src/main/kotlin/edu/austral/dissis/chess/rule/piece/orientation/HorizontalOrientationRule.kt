package rule.piece.orientation

import edu.austral.dissis.chess.board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class HorizontalOrientationRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (move.from.row == move.to.row) return ValidResult
        return InvalidResult("You can't move horizontally!")
    }
}
