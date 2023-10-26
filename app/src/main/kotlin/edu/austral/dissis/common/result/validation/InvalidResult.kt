package edu.austral.dissis.common.result.validation

class InvalidResult(private val message: String): ValidationResult {
    fun getMessage(): String {
        return message
    }
}
