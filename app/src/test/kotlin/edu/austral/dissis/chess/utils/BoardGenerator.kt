package edu.austral.dissis.chess.utils

import ClassicBoard
import board.Board
import board.Position
import factory.piece.ClassicPieceFactory
import factory.rule.ClassicRuleFactory
import piece.Color
import piece.PieceType

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


