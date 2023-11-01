package edu.austral.dissis.chess.start

import edu.austral.dissis.common.board.ClassicBoard
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.factory.piece.ClassicPieceFactory
import edu.austral.dissis.common.start.StartingBoardGenerator
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.chess.piece.ChessPieceType

class ClassicStartingBoard(private val classicPieceFactory: ClassicPieceFactory) : StartingBoardGenerator {
        override fun generate(): Board {
                return ClassicBoard(8, 8, mapOf(
                        Pair(Position(1, 1), classicPieceFactory.createPiece(ChessPieceType.ROOK, Color.BLACK)),
                        Pair(Position(2, 1), classicPieceFactory.createPiece(ChessPieceType.KNIGHT, Color.BLACK)),
                        Pair(Position(3, 1), classicPieceFactory.createPiece(ChessPieceType.BISHOP, Color.BLACK)),
                        Pair(Position(4, 1), classicPieceFactory.createPiece(ChessPieceType.QUEEN, Color.BLACK)),
                        Pair(Position(5, 1), classicPieceFactory.createPiece(ChessPieceType.KING, Color.BLACK)),
                        Pair(Position(6, 1), classicPieceFactory.createPiece(ChessPieceType.BISHOP, Color.BLACK)),
                        Pair(Position(7, 1), classicPieceFactory.createPiece(ChessPieceType.KNIGHT, Color.BLACK)),
                        Pair(Position(8, 1), classicPieceFactory.createPiece(ChessPieceType.ROOK, Color.BLACK)),

                        Pair(Position(1, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
                        Pair(Position(2, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
                        Pair(Position(3, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
                        Pair(Position(4, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
                        Pair(Position(5, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
                        Pair(Position(6, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
                        Pair(Position(7, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),
                        Pair(Position(8, 2), classicPieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK)),

                        Pair(Position(1, 8), classicPieceFactory.createPiece(ChessPieceType.ROOK, Color.WHITE)),
                        Pair(Position(2, 8), classicPieceFactory.createPiece(ChessPieceType.KNIGHT, Color.WHITE)),
                        Pair(Position(3, 8), classicPieceFactory.createPiece(ChessPieceType.BISHOP, Color.WHITE)),
                        Pair(Position(4, 8), classicPieceFactory.createPiece(ChessPieceType.QUEEN, Color.WHITE)),
                        Pair(Position(5, 8), classicPieceFactory.createPiece(ChessPieceType.KING, Color.WHITE)),
                        Pair(Position(6, 8), classicPieceFactory.createPiece(ChessPieceType.BISHOP, Color.WHITE)),
                        Pair(Position(7, 8), classicPieceFactory.createPiece(ChessPieceType.KNIGHT, Color.WHITE)),
                        Pair(Position(8, 8), classicPieceFactory.createPiece(ChessPieceType.ROOK, Color.WHITE)),

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
