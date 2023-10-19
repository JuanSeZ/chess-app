package edu.austral.dissis.chess.factory.rule

import piece.PieceType
import rule.Rule

interface RuleFactory {
    fun createRule(type: PieceType): Rule
}
