package edu.austral.dissis.chess.factory.rule

import edu.austral.dissis.chess.factory.rule.RuleFactory
import piece.PieceType
import edu.austral.dissis.chess.rule.AndRule
import edu.austral.dissis.chess.rule.ForwardDirectionRule
import edu.austral.dissis.chess.rule.OrRule
import edu.austral.dissis.chess.rule.piece.FirstMoveRule
import edu.austral.dissis.chess.rule.piece.HasNotEnemyRule
import rule.Rule
import rule.piece.HasEnemyRule
import edu.austral.dissis.chess.rule.piece.obstacle.DiagonalObstacleRule
import edu.austral.dissis.chess.rule.piece.obstacle.HorizontalObstacleRule
import edu.austral.dissis.chess.rule.piece.obstacle.VerticalObstacleRule
import edu.austral.dissis.chess.rule.piece.orientation.DiagonalOrientationRule
import rule.piece.orientation.HorizontalOrientationRule
import edu.austral.dissis.chess.rule.piece.orientation.LOrientationRule
import rule.piece.orientation.VerticalOrientationRule
import edu.austral.dissis.chess.rule.piece.quantity.LimitedQuantityRule

class ClassicRuleFactory: RuleFactory {
    override fun createRule(type: PieceType): Rule {
        return when (type) {
            PieceType.PAWN -> classicPawnRule()
            PieceType.ROOK -> classicRookRule()
            PieceType.KNIGHT -> classicKnightRule()
            PieceType.BISHOP -> classicBishopRule()
            PieceType.QUEEN -> classicQueenRule()
            PieceType.KING -> classicKingRule()
        }
    }

    private fun classicPawnRule(): Rule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(LimitedQuantityRule(1),VerticalOrientationRule(), VerticalObstacleRule(),HasNotEnemyRule(),ForwardDirectionRule()))
                , AndRule(
                    listOf(LimitedQuantityRule(1), DiagonalOrientationRule(),HasEnemyRule(),ForwardDirectionRule()))
                , AndRule(
                    listOf(LimitedQuantityRule(2), VerticalOrientationRule(), VerticalObstacleRule(),FirstMoveRule(),ForwardDirectionRule(),HasNotEnemyRule()))
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
