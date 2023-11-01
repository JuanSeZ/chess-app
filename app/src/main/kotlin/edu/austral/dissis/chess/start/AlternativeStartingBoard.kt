package edu.austral.dissis.chess.start

import edu.austral.dissis.chess.piece.ChessPieceType
import edu.austral.dissis.common.board.ClassicBoard
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.factory.piece.PieceFactory
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.start.StartingBoardGenerator

class AlternativeStartingBoard(private val classicPieceFactory: PieceFactory) : StartingBoardGenerator {

    override fun generate(): Board {
        return ClassicBoard(8, 8, mapOf(
            Pair(Position(1, 1), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(2, 1), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(3, 1), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(4, 1), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(5, 1), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(6, 1), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(7, 1), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(8, 1), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),

            Pair(Position(1, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(2, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(3, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(4, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(5, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(6, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(7, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
            Pair(Position(8, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),

            Pair(Position(1, 8), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(2, 8), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(3, 8), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(4, 8), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(5, 8), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(6, 8), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(7, 8), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(8, 8), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),

            Pair(Position(1, 7), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(2, 7), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(3, 7), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(4, 7), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(5, 7), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(6, 7), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(7, 7), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE)),
            Pair(Position(8, 7), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE))
        ))
    }
}
