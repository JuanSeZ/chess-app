package rule.piece

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class HasEnemyRule: Rule {
    override fun validate(move: Move): ValidationResult {
        move.board.getPieceAt(move.to)?.let {
            if (it.color != move.turn) return ValidResult
            else return InvalidResult()
        }
        return InvalidResult()
    }
}
