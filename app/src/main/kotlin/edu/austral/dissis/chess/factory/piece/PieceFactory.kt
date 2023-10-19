package edu.austral.dissis.chess.factory.piece

import piece.Color
import edu.austral.dissis.chess.piece.Piece
import piece.PieceType

interface PieceFactory {
    fun createPiece(type: PieceType, color: Color): Piece
}
