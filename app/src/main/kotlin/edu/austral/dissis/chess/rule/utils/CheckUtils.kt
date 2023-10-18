package rule.utils

import board.Board
import board.Move
import board.Position
import piece.Color
import piece.PieceType
import edu.austral.dissis.chess.result.validation.ValidResult

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

fun possibleMoves(board: Board,turn: Color): List<Move> {
    val friendlyPieces : List<Position> = board.getBoard().filterValues { it.color == turn }.keys.toList()
    val possibleMoves : MutableList<Move> = mutableListOf()
    for (i in 1 until board.getColumnsSize()){
        for (j in 1 until board.getRowsSize()){
            val position = Position(i,j)
            for (friendlyPiece in friendlyPieces){
                val possibleMove = Move(board,friendlyPiece,position,turn)
                if (board.getPieceAt(friendlyPiece)?.rule?.validate(possibleMove) == ValidResult) possibleMoves.add(possibleMove)
            }
        }
    }
    return possibleMoves
}
