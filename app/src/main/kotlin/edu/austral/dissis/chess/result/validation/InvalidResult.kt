package edu.austral.dissis.chess.result.validation

import result.validation.ValidationResult

class InvalidResult(private val message: String): ValidationResult {
    fun getMessage(): String {
        return message
    }
}
