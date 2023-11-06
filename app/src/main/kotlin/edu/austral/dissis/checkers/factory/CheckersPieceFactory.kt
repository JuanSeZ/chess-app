package edu.austral.dissis.checkers.factory

import edu.austral.dissis.common.factory.piece.PieceFactory
import edu.austral.dissis.common.factory.rule.RuleFactory
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType

class CheckersPieceFactory(private val ruleFactory: RuleFactory): PieceFactory {
    override fun createPiece(type: PieceType, color: Color): Piece {
        return Piece(type,color,this.ruleFactory.createRule(type))
    }
}
