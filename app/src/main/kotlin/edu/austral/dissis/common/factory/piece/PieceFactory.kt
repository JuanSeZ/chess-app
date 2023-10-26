package edu.austral.dissis.common.factory.piece

import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType

interface PieceFactory {
    fun createPiece(type: PieceType, color: Color): Piece
}
