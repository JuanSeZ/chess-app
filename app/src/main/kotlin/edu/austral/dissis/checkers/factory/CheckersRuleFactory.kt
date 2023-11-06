package edu.austral.dissis.checkers.factory

import edu.austral.dissis.checkers.rule.PawnInBetweenRule
import edu.austral.dissis.common.factory.rule.RuleFactory
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.rule.AndRule
import edu.austral.dissis.common.rule.OrRule
import edu.austral.dissis.common.rule.Rule
import edu.austral.dissis.common.rule.piece.ForwardDirectionRule
import edu.austral.dissis.common.rule.piece.HasNotEnemyRule
import edu.austral.dissis.common.rule.piece.orientation.DiagonalOrientationRule
import edu.austral.dissis.common.rule.piece.quantity.LimitedQuantityRule

class CheckersRuleFactory: RuleFactory {
    override fun createRule(type: PieceType): Rule {
        return when (type.getValue()) {
            "pawn" -> checkersPawnRule()
            "king" -> checkersKingRule()
            else -> {
                throw RuntimeException("Piece type not found")}
        }
    }

    private fun checkersKingRule(): Rule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(
                        LimitedQuantityRule(1), DiagonalOrientationRule(), HasNotEnemyRule()
                    ))
                , AndRule(
                    listOf(
                        LimitedQuantityRule(2), DiagonalOrientationRule(), HasNotEnemyRule(), PawnInBetweenRule()
                    ))
            ))
    }

    private fun checkersPawnRule(): Rule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(
                        LimitedQuantityRule(1),DiagonalOrientationRule(), HasNotEnemyRule(), ForwardDirectionRule()
                    ))
                , AndRule(
                    listOf(
                        LimitedQuantityRule(2), DiagonalOrientationRule(), ForwardDirectionRule(),
                        HasNotEnemyRule(), PawnInBetweenRule()
                    ))
            ))
    }

}
