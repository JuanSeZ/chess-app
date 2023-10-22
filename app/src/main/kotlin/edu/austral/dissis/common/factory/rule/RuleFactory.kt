package edu.austral.dissis.common.factory.rule

import piece.PieceType
import edu.austral.dissis.common.rule.Rule

interface RuleFactory {
    fun createRule(type: PieceType): Rule
}
