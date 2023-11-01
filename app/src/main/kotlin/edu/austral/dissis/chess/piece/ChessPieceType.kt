package edu.austral.dissis.chess.piece

import edu.austral.dissis.common.piece.PieceType

enum class ChessPieceType(private val value: String): PieceType {
    PAWN("pawn"),
    ROOK("rook"),
    KNIGHT("knight"),
    BISHOP("bishop"),
    QUEEN("queen"),
    KING("king");

    override fun getValue(): String {
        return value
    }
}
