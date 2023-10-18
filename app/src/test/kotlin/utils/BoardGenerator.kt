package utils

import ClassicBoard
import board.Board
import board.Position
import factory.piece.ClassicPieceFactory
import factory.rule.ClassicRuleFactory
import piece.Color
import piece.Piece
import piece.PieceType

fun pawnInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(PieceType.PAWN, Color.WHITE),
        )
    )
}
