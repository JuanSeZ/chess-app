package edu.austral.dissis.chess.utils

import edu.austral.dissis.common.board.ClassicBoard
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.factory.piece.ClassicPieceFactory
import edu.austral.dissis.chess.factory.rule.ClassicRuleFactory
import edu.austral.dissis.chess.piece.ChessPieceType
import edu.austral.dissis.common.piece.Color


fun pawnInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE),
        )
    )
}

fun pawnInCenterWithEnemyDiagonal(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.WHITE),
            Position(5,5) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK),
        )
    )
}

fun knightInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(ChessPieceType.KNIGHT, Color.WHITE),
        )
    )
}

fun knightInCenterWithEnemyInL(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(ChessPieceType.KNIGHT, Color.WHITE),
            Position(5,6) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK),
        )
    )
}

fun bishopInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(ChessPieceType.BISHOP, Color.WHITE),
        )
    )
}

fun rookInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(ChessPieceType.ROOK, Color.WHITE),
        )
    )
}

fun queenInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(ChessPieceType.QUEEN, Color.WHITE),
        )
    )
}

fun kingInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(ChessPieceType.KING, Color.WHITE),
        )
    )
}

fun kingIsInCheck(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(1,1) to pieceFactory.createPiece(ChessPieceType.KING, Color.WHITE),
            Position(1,2) to pieceFactory.createPiece(ChessPieceType.ROOK, Color.BLACK),
        )
    )
}

fun kingIsInCheckmate(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(1,1) to pieceFactory.createPiece(ChessPieceType.KING, Color.WHITE),
            Position(1,2) to pieceFactory.createPiece(ChessPieceType.ROOK, Color.BLACK),
            Position(2,2) to pieceFactory.createPiece(ChessPieceType.ROOK, Color.BLACK),
        )
    )
}

fun blackQueenInPlace(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,1) to pieceFactory.createPiece(ChessPieceType.QUEEN, Color.BLACK),
            Position(1,1) to pieceFactory.createPiece(ChessPieceType.ROOK, Color.BLACK),
            Position(2,1) to pieceFactory.createPiece(ChessPieceType.KNIGHT, Color.BLACK),
            Position(3,1) to pieceFactory.createPiece(ChessPieceType.BISHOP, Color.BLACK),
            Position(5,1) to pieceFactory.createPiece(ChessPieceType.BISHOP, Color.BLACK),
            Position(6,1) to pieceFactory.createPiece(ChessPieceType.KNIGHT, Color.BLACK),
            Position(7,1) to pieceFactory.createPiece(ChessPieceType.ROOK, Color.BLACK),
            Position(1,2) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK),
            Position(2,2) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK),
            Position(3,2) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK),
            Position(4,2) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK),
            Position(5,3) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK),
            Position(6,2) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK),
            Position(7,2) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK),
            Position(8,2) to pieceFactory.createPiece(ChessPieceType.PAWN, Color.BLACK),
        )
    )
}


