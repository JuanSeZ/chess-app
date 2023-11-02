package edu.austral.dissis.chess.factory.rule

import edu.austral.dissis.common.factory.rule.RuleFactory
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.rule.AndRule
import edu.austral.dissis.common.rule.piece.ForwardDirectionRule
import edu.austral.dissis.common.rule.OrRule
import edu.austral.dissis.common.rule.piece.FirstMoveRule
import edu.austral.dissis.common.rule.piece.HasNotEnemyRule
import edu.austral.dissis.common.rule.Rule
import rule.piece.HasEnemyRule
import edu.austral.dissis.common.rule.piece.obstacle.DiagonalObstacleRule
import edu.austral.dissis.common.rule.piece.obstacle.HorizontalObstacleRule
import edu.austral.dissis.common.rule.piece.obstacle.VerticalObstacleRule
import edu.austral.dissis.common.rule.piece.orientation.DiagonalOrientationRule
import rule.piece.orientation.HorizontalOrientationRule
import edu.austral.dissis.common.rule.piece.orientation.LOrientationRule
import rule.piece.orientation.VerticalOrientationRule
import edu.austral.dissis.common.rule.piece.quantity.LimitedQuantityRule

class ClassicRuleFactory: RuleFactory {
    override fun createRule(type: PieceType): Rule {
        return when (type.getValue()) {
            "pawn" -> classicPawnRule()
            "rook" -> classicRookRule()
            "knight" -> classicKnightRule()
            "bishop" -> classicBishopRule()
            "queen" -> classicQueenRule()
            "king" -> classicKingRule()
            else -> {
                throw RuntimeException("Piece type not found")}
        }
    }

    private fun classicPawnRule(): Rule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(
                        LimitedQuantityRule(1),VerticalOrientationRule(), VerticalObstacleRule(),
                        HasNotEnemyRule(), ForwardDirectionRule()
                    ))
                , AndRule(
                    listOf(LimitedQuantityRule(1), DiagonalOrientationRule(),HasEnemyRule(), ForwardDirectionRule()))
                , AndRule(
                    listOf(
                        LimitedQuantityRule(2), VerticalOrientationRule(), VerticalObstacleRule(),
                        FirstMoveRule(), ForwardDirectionRule(),
                        HasNotEnemyRule()
                    ))
            ))
    }

    private fun classicRookRule(): Rule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(VerticalOrientationRule(), VerticalObstacleRule()))
                , AndRule(
                    listOf(HorizontalOrientationRule(), HorizontalObstacleRule())
                )
            )
        )
    }

    private fun classicKnightRule(): Rule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(LOrientationRule())
                )
            )
        )
    }

    private fun classicBishopRule(): Rule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(DiagonalOrientationRule(), DiagonalObstacleRule())
                )
            )
        )
    }

    private fun classicQueenRule(): Rule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(VerticalOrientationRule(), VerticalObstacleRule()))
                , AndRule(
                    listOf(HorizontalOrientationRule(), HorizontalObstacleRule())
                )
                , AndRule(
                    listOf(DiagonalOrientationRule(), DiagonalObstacleRule())
                )
            )
        )
    }

    private fun classicKingRule(): Rule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(LimitedQuantityRule(1),VerticalOrientationRule(), VerticalObstacleRule()))
                , AndRule(
                    listOf(LimitedQuantityRule(1),HorizontalOrientationRule(), HorizontalObstacleRule())
                )
                , AndRule(
                    listOf(LimitedQuantityRule(1), DiagonalOrientationRule(), DiagonalObstacleRule())
                )
            )
        )
    }



}
