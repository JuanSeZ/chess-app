package rule

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult

class OrRule(private val rules: List<Rule>) : Rule {
    override fun validate(move: Move): ValidationResult {
        for (rule in rules) {
            if (rule.validate(move) is ValidResult) return rule.validate(move)
        }
        return InvalidResult()
    }
}
