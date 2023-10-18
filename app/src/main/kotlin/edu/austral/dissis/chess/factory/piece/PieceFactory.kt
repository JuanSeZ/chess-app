package factory.piece

import piece.Color
import piece.Piece
import piece.PieceType

interface PieceFactory {
    fun createPiece(type: PieceType, color: Color): Piece
}
