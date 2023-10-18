package edu.austral.dissis.chess.rule

import board.Move
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule

class AndRule(private val rules: List<Rule>) : Rule {
    override fun validate(move: Move): ValidationResult {
        for (rule in rules) {
            if (rule.validate(move) !is ValidResult) return rule.validate(move)
        }
        return ValidResult
    }
}
