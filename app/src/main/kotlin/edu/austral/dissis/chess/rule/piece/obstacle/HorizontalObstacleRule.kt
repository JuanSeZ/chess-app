package rule.piece.obstacle

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class HorizontalObstacleRule : Rule {
    override fun validate(move: Move): ValidationResult {
        val (start, end) = if (move.from.x > move.to.x) {
            move.to.x + 1 to move.from.x
        } else {
            move.from.x + 1 to move.to.x
        }
        for (i in start until end) {
            if (move.board.getPieceAt(move.from.copy(x = i)) != null) {
                return InvalidResult()
            }
        }
        return ValidResult
    }
}
