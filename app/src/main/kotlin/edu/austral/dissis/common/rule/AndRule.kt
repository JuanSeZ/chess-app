package edu.austral.dissis.common.rule

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.ValidResult
import result.validation.ValidationResult

class AndRule(private val rules: List<Rule>) : Rule {
    override fun validate(move: Move): ValidationResult {
        for (rule in rules) {
            if (rule.validate(move) !is ValidResult) return rule.validate(move)
        }
        return ValidResult
    }
}
