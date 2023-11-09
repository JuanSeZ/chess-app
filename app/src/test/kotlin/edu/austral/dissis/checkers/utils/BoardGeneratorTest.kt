package edu.austral.dissis.checkers.utils

import edu.austral.dissis.checkers.factory.CheckersPieceFactory
import edu.austral.dissis.checkers.factory.CheckersRuleFactory
import edu.austral.dissis.checkers.piece.CheckersPieceType
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.ClassicBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.piece.Color

fun pawnInCenterWithEnemyDiagonal():Board {
    val checkersPieceFactory = CheckersPieceFactory(CheckersRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to checkersPieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE),
            Position(5,5) to checkersPieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK),
            Position(3,3) to checkersPieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK),
            Position(3,5) to checkersPieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK),
            Position(5,3) to checkersPieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK),
        )
    )
}


fun pawnInCenterWithTwoEnemyDiagonal():Board {
    val checkersPieceFactory = CheckersPieceFactory(CheckersRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to checkersPieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE),
            Position(5,5) to checkersPieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK),
            Position(6,6) to checkersPieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK),
    )
    )
}

fun pawnInCenterWithEnemyTwoBlocksAwayDiagonal():Board {
    val checkersPieceFactory = CheckersPieceFactory(CheckersRuleFactory())
    return ClassicBoard(
        8,8,
        mapOf(
            Position(4,4) to checkersPieceFactory.createPiece(CheckersPieceType.PAWN, Color.WHITE),
            Position(6,6) to checkersPieceFactory.createPiece(CheckersPieceType.PAWN, Color.BLACK),
        )
    )
}
