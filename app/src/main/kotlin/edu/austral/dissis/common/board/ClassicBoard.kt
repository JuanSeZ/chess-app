package edu.austral.dissis.common.board

import edu.austral.dissis.common.piece.Piece



class ClassicBoard(private val xSize: Int,private val ySize: Int,private val positions: Map<Position, Piece>) : Board {

    override fun move(from: Position, to: Position): Board {
        if(!positions.containsKey(from)) throw IllegalArgumentException("No piece at $from")
        val piece = positions[from]!!

        return ClassicBoard(xSize, ySize, positions+ Pair(to, piece.copy(
            moveCount = piece.getMoveCount() + 1,
            id = piece.getId()
        )) - from)
    }

    override fun getPieceAt(position: Position): Piece? {
        return positions[position]
    }

    override fun getBoard(): Map<Position, Piece> {
        return positions
    }

    override fun getColumnsSize(): Int {
        return xSize
    }

    override fun getRowsSize(): Int {
        return ySize
    }

    override fun getOccupiedPositions(): List<Position> {
        return positions.keys.toList()
    }

    override fun removePiece(position: Position): Board {
        return ClassicBoard(xSize, ySize, positions - position)
    }
}
