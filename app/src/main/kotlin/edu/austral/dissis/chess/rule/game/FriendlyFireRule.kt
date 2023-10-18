package rule.game

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class FriendlyFireRule : Rule{
    override fun validate(move: Move): ValidationResult {
        if (move.board.getPieceAt(move.to)?.color != move.board.getPieceAt(move.from)?.color) return ValidResult
        return InvalidResult()
    }
}
