package edu.austral.dissis.common.factory.piece

import piece.Color
import edu.austral.dissis.common.piece.Piece
import piece.PieceType

interface PieceFactory {
    fun createPiece(type: PieceType, color: Color): Piece
}
