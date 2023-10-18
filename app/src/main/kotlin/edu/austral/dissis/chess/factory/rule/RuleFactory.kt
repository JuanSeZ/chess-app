package factory.rule

import piece.PieceType
import rule.Rule

interface RuleFactory {
    fun createRule(type: PieceType): Rule
}
