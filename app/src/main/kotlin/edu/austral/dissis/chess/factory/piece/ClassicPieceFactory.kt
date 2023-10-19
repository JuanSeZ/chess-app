package edu.austral.dissis.chess.factory.piece

import edu.austral.dissis.chess.factory.rule.RuleFactory
import piece.Color
import edu.austral.dissis.chess.piece.Piece
import piece.PieceType

class ClassicPieceFactory(private val ruleFactory: RuleFactory) : PieceFactory {
    override fun createPiece(type: PieceType, color: Color): Piece {
        return Piece(type, color, ruleFactory.createRule(type))
    }
}
