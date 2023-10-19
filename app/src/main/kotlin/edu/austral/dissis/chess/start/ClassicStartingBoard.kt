package start

import ClassicBoard
import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.factory.piece.ClassicPieceFactory
import edu.austral.dissis.chess.factory.piece.PieceFactory
import edu.austral.dissis.chess.factory.rule.ClassicRuleFactory
import piece.Color
import piece.PieceType

class ClassicStartingBoard(private val classicPieceFactory: ClassicPieceFactory) : StartingBoardGenerator {
    override fun generate(): Board {
        return ClassicBoard(8, 8, mapOf(
                Pair(Position(1, 1), classicPieceFactory.createPiece(PieceType.ROOK, Color.BLACK)),
                Pair(Position(2, 1), classicPieceFactory.createPiece(PieceType.KNIGHT, Color.BLACK)),
                Pair(Position(3, 1), classicPieceFactory.createPiece(PieceType.BISHOP, Color.BLACK)),
                Pair(Position(4, 1), classicPieceFactory.createPiece(PieceType.QUEEN, Color.BLACK)),
                Pair(Position(5, 1), classicPieceFactory.createPiece(PieceType.KING, Color.BLACK)),
                Pair(Position(6, 1), classicPieceFactory.createPiece(PieceType.BISHOP, Color.BLACK)),
                Pair(Position(7, 1), classicPieceFactory.createPiece(PieceType.KNIGHT, Color.BLACK)),
                Pair(Position(8, 1), classicPieceFactory.createPiece(PieceType.ROOK, Color.BLACK)),

                Pair(Position(1, 2), classicPieceFactory.createPiece(PieceType.PAWN, Color.BLACK)),
                Pair(Position(2, 2), classicPieceFactory.createPiece(PieceType.PAWN, Color.BLACK)),
                Pair(Position(3, 2), classicPieceFactory.createPiece(PieceType.PAWN, Color.BLACK)),
                Pair(Position(4, 2), classicPieceFactory.createPiece(PieceType.PAWN, Color.BLACK)),
                Pair(Position(5, 2), classicPieceFactory.createPiece(PieceType.PAWN, Color.BLACK)),
                Pair(Position(6, 2), classicPieceFactory.createPiece(PieceType.PAWN, Color.BLACK)),
                Pair(Position(7, 2), classicPieceFactory.createPiece(PieceType.PAWN, Color.BLACK)),
                Pair(Position(8, 2), classicPieceFactory.createPiece(PieceType.PAWN, Color.BLACK)),

                Pair(Position(1, 8), classicPieceFactory.createPiece(PieceType.ROOK, Color.WHITE)),
                Pair(Position(2, 8), classicPieceFactory.createPiece(PieceType.KNIGHT, Color.WHITE)),
                Pair(Position(3, 8), classicPieceFactory.createPiece(PieceType.BISHOP, Color.WHITE)),
                Pair(Position(4, 8), classicPieceFactory.createPiece(PieceType.QUEEN, Color.WHITE)),
                Pair(Position(5, 8), classicPieceFactory.createPiece(PieceType.KING, Color.WHITE)),
                Pair(Position(6, 8), classicPieceFactory.createPiece(PieceType.BISHOP, Color.WHITE)),
                Pair(Position(7, 8), classicPieceFactory.createPiece(PieceType.KNIGHT, Color.WHITE)),

                Pair(Position(8, 8), classicPieceFactory.createPiece(PieceType.ROOK, Color.WHITE)),
                Pair(Position(1, 7), classicPieceFactory.createPiece(PieceType.PAWN, Color.WHITE)),
                Pair(Position(2, 7), classicPieceFactory.createPiece(PieceType.PAWN, Color.WHITE)),
                Pair(Position(3, 7), classicPieceFactory.createPiece(PieceType.PAWN, Color.WHITE)),
                Pair(Position(4, 7), classicPieceFactory.createPiece(PieceType.PAWN, Color.WHITE)),
                Pair(Position(5, 7), classicPieceFactory.createPiece(PieceType.PAWN, Color.WHITE)),
                Pair(Position(6, 7), classicPieceFactory.createPiece(PieceType.PAWN, Color.WHITE)),
                Pair(Position(7, 7), classicPieceFactory.createPiece(PieceType.PAWN, Color.WHITE)),
                Pair(Position(8, 7), classicPieceFactory.createPiece(PieceType.PAWN, Color.WHITE))
        ))
    }
}
