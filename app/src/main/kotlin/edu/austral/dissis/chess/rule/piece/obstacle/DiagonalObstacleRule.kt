package rule.piece.obstacle

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class DiagonalObstacleRule: Rule {
    override fun validate(move: Move): ValidationResult {
        val (start, end) = if (move.from.column > move.to.column) {
            move.to.column + 1 to move.from.column
        } else {
            move.from.column + 1 to move.to.column
        }
        val (startY, endY) = if (move.from.row > move.to.row) {
            move.to.row + 1 to move.from.row
        } else {
            move.from.row + 1 to move.to.row
        }
        for (i in start until end) {
            for (j in startY until endY) {
                if (move.board.getPieceAt(move.from.copy(column = i, row = j)) != null) {
                    return InvalidResult()
                }
            }
        }
        return ValidResult
    }
}
