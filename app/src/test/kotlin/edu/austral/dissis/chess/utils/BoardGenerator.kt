package edu.austral.dissis.chess.utils

import edu.austral.dissis.common.board.ClassicBoard
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.factory.piece.ClassicPieceFactory
import edu.austral.dissis.chess.factory.rule.ClassicRuleFactory
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.piece.PieceType

fun pawnInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(PieceType.PAWN, Color.WHITE),
        )
    )
}

fun pawnInCenterWithEnemyDiagonal(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(PieceType.PAWN, Color.WHITE),
            Position(5,5) to pieceFactory.createPiece(PieceType.PAWN, Color.BLACK),
        )
    )
}

fun knightInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(PieceType.KNIGHT, Color.WHITE),
        )
    )
}

fun knightInCenterWithEnemyInL(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(PieceType.KNIGHT, Color.WHITE),
            Position(5,6) to pieceFactory.createPiece(PieceType.PAWN, Color.BLACK),
        )
    )
}

fun bishopInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(PieceType.BISHOP, Color.WHITE),
        )
    )
}

fun rookInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(PieceType.ROOK, Color.WHITE),
        )
    )
}

fun queenInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(PieceType.QUEEN, Color.WHITE),
        )
    )
}

fun kingInCenter(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to pieceFactory.createPiece(PieceType.KING, Color.WHITE),
        )
    )
}

fun kingIsInCheck(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(1,1) to pieceFactory.createPiece(PieceType.KING, Color.WHITE),
            Position(1,2) to pieceFactory.createPiece(PieceType.ROOK, Color.BLACK),
        )
    )
}

fun kingIsInCheckmate(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(1,1) to pieceFactory.createPiece(PieceType.KING, Color.WHITE),
            Position(1,2) to pieceFactory.createPiece(PieceType.ROOK, Color.BLACK),
            Position(2,2) to pieceFactory.createPiece(PieceType.ROOK, Color.BLACK),
        )
    )
}

fun blackQueenInPlace(): Board {
    val pieceFactory = ClassicPieceFactory(ClassicRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,1) to pieceFactory.createPiece(PieceType.QUEEN, Color.BLACK),
            Position(1,1) to pieceFactory.createPiece(PieceType.ROOK, Color.BLACK),
            Position(2,1) to pieceFactory.createPiece(PieceType.KNIGHT, Color.BLACK),
            Position(3,1) to pieceFactory.createPiece(PieceType.BISHOP, Color.BLACK),
            Position(5,1) to pieceFactory.createPiece(PieceType.BISHOP, Color.BLACK),
            Position(6,1) to pieceFactory.createPiece(PieceType.KNIGHT, Color.BLACK),
            Position(7,1) to pieceFactory.createPiece(PieceType.ROOK, Color.BLACK),
            Position(1,2) to pieceFactory.createPiece(PieceType.PAWN, Color.BLACK),
            Position(2,2) to pieceFactory.createPiece(PieceType.PAWN, Color.BLACK),
            Position(3,2) to pieceFactory.createPiece(PieceType.PAWN, Color.BLACK),
            Position(4,2) to pieceFactory.createPiece(PieceType.PAWN, Color.BLACK),
            Position(5,3) to pieceFactory.createPiece(PieceType.PAWN, Color.BLACK),
            Position(6,2) to pieceFactory.createPiece(PieceType.PAWN, Color.BLACK),
            Position(7,2) to pieceFactory.createPiece(PieceType.PAWN, Color.BLACK),
            Position(8,2) to pieceFactory.createPiece(PieceType.PAWN, Color.BLACK),
        )
    )
}

