package edu.austral.dissis.chess.piece

import piece.Color
import piece.PieceType
import rule.Rule

data class Piece(val type: PieceType, val color: Color, val rule: Rule, private val moveCount: Int = 0, private val id: String = "") {

     fun getId(): String {
        if (this.id != "") return this.id
        return this.hashCode().toString()
    }

    fun getMoveCount(): Int {
        return this.moveCount
    }
}
