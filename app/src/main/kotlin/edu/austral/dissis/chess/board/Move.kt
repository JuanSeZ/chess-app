package board

import piece.Color

data class Move(val board: Board,  val from: Position,val to: Position, val turn: Color){}
