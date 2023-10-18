package factory.rule

import piece.PieceType
import rule.AndRule
import rule.OrRule
import rule.Rule
import rule.piece.HasEnemyRule
import rule.piece.obstacle.DiagonalObstacleRule
import rule.piece.obstacle.HorizontalObstacleRule
import rule.piece.obstacle.VerticalObstacleRule
import rule.piece.orientation.DiagonalOrientationRule
import rule.piece.orientation.HorizontalOrientationRule
import rule.piece.orientation.LOrientationRule
import rule.piece.orientation.VerticalOrientationRule
import rule.piece.quantity.LimitedQuantityRule

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
//        TODO: Add first move rule
        return OrRule(
            listOf(
                AndRule(
                    listOf(LimitedQuantityRule(1),VerticalOrientationRule(), VerticalObstacleRule()))
                ,AndRule(
                    listOf(LimitedQuantityRule(1),DiagonalOrientationRule(),HasEnemyRule()))
            ))
    }

    private fun classicRookRule(): Rule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(VerticalOrientationRule(), VerticalObstacleRule()))
                ,AndRule(
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
                ,AndRule(
                    listOf(HorizontalOrientationRule(), HorizontalObstacleRule())
                )
                ,AndRule(
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
                ,AndRule(
                    listOf(LimitedQuantityRule(1),HorizontalOrientationRule(), HorizontalObstacleRule())
                )
                ,AndRule(
                    listOf(LimitedQuantityRule(1),DiagonalOrientationRule(), DiagonalObstacleRule())
                )
            )
        )
    }



}