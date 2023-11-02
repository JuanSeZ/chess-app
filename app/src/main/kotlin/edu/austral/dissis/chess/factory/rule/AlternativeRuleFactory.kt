package edu.austral.dissis.chess.factory.rule

import edu.austral.dissis.common.rule.AndRule
import edu.austral.dissis.common.rule.OrRule
import edu.austral.dissis.common.rule.piece.obstacle.DiagonalObstacleRule
import edu.austral.dissis.common.rule.piece.obstacle.HorizontalObstacleRule
import edu.austral.dissis.common.rule.piece.obstacle.VerticalObstacleRule
import edu.austral.dissis.common.rule.piece.orientation.DiagonalOrientationRule
import edu.austral.dissis.common.factory.rule.RuleFactory
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.rule.Rule
import rule.piece.orientation.HorizontalOrientationRule
import rule.piece.orientation.VerticalOrientationRule

class AlternativeRuleFactory : RuleFactory {
    override fun createRule(type: PieceType): Rule {
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
}
