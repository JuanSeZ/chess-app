package factory.piece

import factory.rule.RuleFactory
import piece.Color
import piece.Piece
import piece.PieceType

class ClassicPieceFactory(private val ruleFactory: RuleFactory) : PieceFactory {
    override fun createPiece(type: PieceType, color: Color): Piece {
        return Piece(type, color, ruleFactory.createRule(type))
    }
}
