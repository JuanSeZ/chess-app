package edu.austral.dissis.checkers.start

import edu.austral.dissis.checkers.piece.CheckersPieceType
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.ClassicBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.factory.piece.PieceFactory
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.start.StartingBoardGenerator

class CheckersStartingBoard(private val pieceFactory: PieceFactory): StartingBoardGenerator {

    override fun generate(): Board {
        return ClassicBoard(8, 8, mapOf(
            Pair(Position(2, 1), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),
            Pair(Position(4, 1), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),
            Pair(Position(6, 1), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),
            Pair(Position(8, 1), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),

            Pair(Position(1, 2), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),
            Pair(Position(3, 2), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),
            Pair(Position(5, 2), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),
            Pair(Position(7, 2), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),

            Pair(Position(2, 3), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),
            Pair(Position(4, 3), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),
            Pair(Position(6, 3), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),
            Pair(Position(8, 3), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK)),

            Pair(Position(1, 6), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE)),
            Pair(Position(3, 6), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE)),
            Pair(Position(5, 6), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE)),
            Pair(Position(7, 6), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE)),

            Pair(Position(2, 7), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE)),
            Pair(Position(4, 7), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE)),
            Pair(Position(6, 7), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE)),
            Pair(Position(8, 7), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE)),

            Pair(Position(1, 8), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE)),
            Pair(Position(3, 8), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE)),
            Pair(Position(5, 8), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE)),
            Pair(Position(7, 8), pieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE))
        ))
    }
}
