package rule.piece.orientation

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class VerticalOrientationRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (move.from.column == move.to.column) return ValidResult
        return InvalidResult("You can't move vertically!")
    }
}
