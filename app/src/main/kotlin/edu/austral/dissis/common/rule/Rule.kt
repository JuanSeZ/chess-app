package edu.austral.dissis.common.rule

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.ValidationResult

interface Rule : ValidationResult {
    fun validate(move: Move): ValidationResult
}
