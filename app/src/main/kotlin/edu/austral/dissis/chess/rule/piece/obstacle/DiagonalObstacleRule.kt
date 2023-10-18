package rule.piece.obstacle

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class DiagonalObstacleRule: Rule {
    override fun validate(move: Move): ValidationResult {
        val (start, end) = if (move.from.x > move.to.x) {
            move.to.x + 1 to move.from.x
        } else {
            move.from.x + 1 to move.to.x
        }
        val (startY, endY) = if (move.from.y > move.to.y) {
            move.to.y + 1 to move.from.y
        } else {
            move.from.y + 1 to move.to.y
        }
        for (i in start until end) {
            for (j in startY until endY) {
                if (move.board.getPieceAt(move.from.copy(x = i, y = j)) != null) {
                    return InvalidResult()
                }
            }
        }
        return ValidResult
    }
}
