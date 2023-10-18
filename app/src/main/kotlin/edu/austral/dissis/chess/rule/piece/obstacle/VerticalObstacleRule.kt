package rule.piece.obstacle

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class VerticalObstacleRule : Rule {
    override fun validate(move: Move): ValidationResult {
        val (start, end) = if (move.from.row > move.to.row) {
            move.to.row + 1 to move.from.row
        } else {
            move.from.row + 1 to move.to.row
        }
        for (i in start until end) {
            if (move.board.getPieceAt(move.from.copy(row = i)) != null) {
                return InvalidResult()
            }
        }
        return ValidResult
    }
}
