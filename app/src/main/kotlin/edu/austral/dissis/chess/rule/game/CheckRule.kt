package rule.game

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule
import rule.utils.isInCheck

class CheckRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if(isInCheck(move.board,move.turn)) return InvalidResult()
        return ValidResult
    }
}
