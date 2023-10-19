package edu.austral.dissis.chess.rule.utils

import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Move
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.result.validation.InvalidResult
import piece.Color
import piece.PieceType
import edu.austral.dissis.chess.result.validation.ValidResult
import rule.Rule

fun isInCheck(board: Board, turn: Color): Boolean {
    val kingPosition : Position = board.getBoard().filterValues { it.type == PieceType.KING && it.color == turn }.keys.first()
    val enemyPieces : List<Position> = board.getBoard().filterValues { it.color != turn }.keys.toList()
    for (enemyPiece in enemyPieces) {
        val enemyPieceRule = board.getPieceAt(enemyPiece)?.rule
        if (enemyPieceRule?.validate(Move(board, enemyPiece, kingPosition, turn)) == ValidResult) {
            return true
        }
    }
    return false
}

 fun findPossibleMoves(piecePosition: Position, board: Board, gameRules: List<Rule>): List<Move>{
    val piece = board.getPieceAt(piecePosition) ?: throw NoSuchElementException("No piece found")
    val team = piece.color
    var validMoves = emptyList<Move>()
    for(i in 1..board.getRowsSize()){
        for(j in 1..board.getColumnsSize()){
            val to = Position(i,j)
            val move = Move(board,piecePosition, to, team)
            if(piece.rule.validate(move) is ValidResult && gameRules.all { it.validate(move) is ValidResult }){
                validMoves = validMoves.plus(move)
            }
        }
    }
    return validMoves
}
fun isInCheckAfterMove(move: Move): Boolean {
    val newBoard = move.board.move(move.from,move.to)
    return isInCheck(newBoard,move.turn)
}

fun isCheck(board: Board, turn: Color): Boolean {
    val kingPosition: Position = getKingPosition(board, turn) ?: throw NoSuchElementException("No king found")
    val enemyPieces: List<Position> = board.getOccupiedPositions()

    for (enemyPiece in enemyPieces) {
        if (attacksKing(board, enemyPiece, turn, kingPosition)) return true
    }
    return false
}

fun getKingPosition(board: Board, turn: Color): Position? {
    val positions = board.getOccupiedPositions()
    for (position in positions) {
        val piece = board.getPieceAt(position) ?: throw NoSuchElementException("No piece found")
        if (piece.type == PieceType.KING && piece.color == turn) return position
    }
    return null
}

fun oppositeColor(turn: Color): Color {
    return when (turn) {
        Color.WHITE -> Color.BLACK
        Color.BLACK -> Color.WHITE
    }
}

fun attacksKing(board: Board, position: Position,turn: Color, kingsPosition: Position): Boolean {
    if (board.getPieceAt(position)?.color != turn) {
        val piece = board.getPieceAt(position) ?: throw NoSuchElementException("No piece found")
        when (
            piece.rule.validate(
                Move(board,position, kingsPosition, turn)
            )
        ) {
            is ValidResult -> return true
            is InvalidResult -> {}
            else -> {}
        }
    }
    return false
}


