package rule

import edu.austral.dissis.chess.board.Move
import result.validation.ValidationResult

interface Rule : ValidationResult {
    fun validate(move: Move): ValidationResult
}
