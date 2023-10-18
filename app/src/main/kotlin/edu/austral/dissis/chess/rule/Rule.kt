package rule

import board.Move
import result.validation.ValidationResult

interface Rule : ValidationResult {
    fun validate(move: Move): ValidationResult
}
