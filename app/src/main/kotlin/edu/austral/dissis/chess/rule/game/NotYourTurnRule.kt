package rule.game

import edu.austral.dissis.chess.board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class NotYourTurnRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (move.turn == move.board.getPieceAt(move.from)?.color) return ValidResult
        return InvalidResult("It's not your turn!")
    }
}
