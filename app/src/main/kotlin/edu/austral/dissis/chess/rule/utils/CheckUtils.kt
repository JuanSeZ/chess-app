package edu.austral.dissis.chess.rule.utils

import board.Board
import board.Move
import board.Position
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

fun possibleMoves(position: Position,board: Board,globalRules: List<Rule>): List<Move> {
    val piece = board.getPieceAt(position) ?: return emptyList()
    val turn = piece.color
    val possibleMoves = mutableListOf<Move>()
    for (i in 1..board.getRowsSize()){
        for (j in 1..board.getColumnsSize()){
            val move = Move(board,position,Position(i,j),turn)
            if (piece.rule.validate(move) == ValidResult && globalRules.all { it.validate(move) == ValidResult }) {
                possibleMoves.add(move)
            }
        }
    }
    return possibleMoves
}
fun isInCheckAfterMove(move: Move): Boolean {
    val newBoard = move.board.move(move.from,move.to)
    return isInCheck(newBoard,move.turn)
}

fun enemyPiecesPositions(board: Board, turn: Color): List<Position> {
    return board.getBoard().filterValues { it.color != turn }.keys.toList()
}
