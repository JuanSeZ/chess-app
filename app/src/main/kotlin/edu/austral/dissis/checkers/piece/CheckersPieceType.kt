package edu.austral.dissis.checkers.piece

import edu.austral.dissis.common.piece.PieceType

enum class CheckersPieceType(private val value: String): PieceType {
    PAWN("pawn"),
    KING("king");

    override fun getValue(): String {
        return value
    }

}
