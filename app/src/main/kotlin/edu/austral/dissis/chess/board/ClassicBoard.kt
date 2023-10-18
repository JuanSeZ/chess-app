import board.Board
import board.Position
import piece.Piece



class ClassicBoard(private val xSize: Int,private val ySize: Int,private val positions: Map<Position,Piece>) : Board {

    override fun move(from: Position, to: Position): Board {
        if(!positions.containsKey(from)) throw IllegalArgumentException("No piece at $from")
        return ClassicBoard(xSize, ySize, positions+ Pair(to, positions[from]!!) - from)
    }

    override fun getPieceAt(position: Position): Piece? {
        return positions[position]?: throw IllegalArgumentException("No piece at $position")
    }

    override fun getBoard(): Map<Position, Piece> {
        return positions
    }

    override fun getXSize(): Int {
        return xSize
    }

    override fun getYSize(): Int {
        return ySize
    }
}
