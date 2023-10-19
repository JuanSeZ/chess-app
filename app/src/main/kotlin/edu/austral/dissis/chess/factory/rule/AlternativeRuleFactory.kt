package edu.austral.dissis.chess.factory.rule

import edu.austral.dissis.chess.rule.AndRule
import edu.austral.dissis.chess.rule.OrRule
import edu.austral.dissis.chess.rule.piece.obstacle.DiagonalObstacleRule
import edu.austral.dissis.chess.rule.piece.obstacle.HorizontalObstacleRule
import edu.austral.dissis.chess.rule.piece.obstacle.VerticalObstacleRule
import edu.austral.dissis.chess.rule.piece.orientation.DiagonalOrientationRule
import piece.PieceType
import rule.Rule
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
