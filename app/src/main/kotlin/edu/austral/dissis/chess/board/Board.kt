package board

import piece.Piece

interface Board {
    fun move(from: Position, to: Position): Board
    fun getPieceAt(position: Position): Piece?
    fun getBoard(): Map<Position, Piece>
    fun getColumnsSize(): Int
    fun getRowsSize(): Int
    fun getOccupiedPositions(): List<Position>
}

