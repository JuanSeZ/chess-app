package rule.piece.obstacle

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class HorizontalObstacleRule : Rule {
    override fun validate(move: Move): ValidationResult {
        val (start, end) = if (move.from.column > move.to.column) {
            move.to.column + 1 to move.from.column
        } else {
            move.from.column + 1 to move.to.column
        }
        for (i in start until end) {
            if (move.board.getPieceAt(move.from.copy(column = i)) != null) {
                return InvalidResult()
            }
        }
        return ValidResult
    }
}
