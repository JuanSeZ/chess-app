package edu.austral.dissis.common.factory.rule

import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.rule.Rule

interface RuleFactory {
    fun createRule(type: PieceType): Rule
}
