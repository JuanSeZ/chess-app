package edu.austral.dissis.common.piece

import edu.austral.dissis.common.rule.Rule

data class Piece(val type: PieceType, val color: Color, val rule: Rule, private val moveCount: Int = 0, private val id: String = "") {

     fun getId(): String {
        if (isEmpty()) return this.id
        return this.hashCode().toString()
    }

    private fun isEmpty() = this.id != ""

    fun getMoveCount(): Int {
        return this.moveCount
    }
}
