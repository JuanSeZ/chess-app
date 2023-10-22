package edu.austral.dissis.common.rule

import edu.austral.dissis.common.board.Move
import result.validation.ValidationResult

interface Rule : ValidationResult {
    fun validate(move: Move): ValidationResult
}
