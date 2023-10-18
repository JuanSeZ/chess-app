package rule.piece.obstacle

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class VerticalObstacleRule : Rule {
    override fun validate(move: Move): ValidationResult {
        val (start, end) = if (move.from.y > move.to.y) {
            move.to.y + 1 to move.from.y
        } else {
            move.from.y + 1 to move.to.y
        }
        for (i in start until end) {
            if (move.board.getPieceAt(move.from.copy(y = i)) != null) {
                return InvalidResult()
            }
        }
        return ValidResult
    }
}
