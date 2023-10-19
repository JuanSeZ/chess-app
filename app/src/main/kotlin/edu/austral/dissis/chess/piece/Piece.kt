package piece

import rule.Rule

data class Piece(val type: PieceType, val color: Color, val rule: Rule) {

    fun getId(): String {
        return this.hashCode().toString()
    }
}
