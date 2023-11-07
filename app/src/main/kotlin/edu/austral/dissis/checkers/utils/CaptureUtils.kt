package edu.austral.dissis.checkers.utils

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.board.Position

fun isCapture(move: Move): Boolean {
    val from = move.from
    val to = move.to

    val rowDirection = if (to.row > from.row) 1 else -1
    val colDirection = if (to.column > from.column) 1 else -1

    var currentRow = from.row + rowDirection
    var currentCol = from.column + colDirection

    val currentPosition = Position(currentCol, currentRow)

    println(currentPosition)

    val piece = move.board.getPieceAt(currentPosition)

    println(piece != null && piece.color != move.turn)
    return piece != null && piece.color != move.turn

}

fun isPossibleToCapture(move: Move): Boolean {
    return when (move.board.getBoard()[move.from]?.type?.getValue()){
        "pawn" -> isPossibleToCapturePawn(move)
        "king" -> isPossibleToCaptureKing(move) && isPossibleToCapturePawn(move)
        else -> false
    }

}

private fun isPossibleToCaptureKing(move: Move): Boolean {
    TODO("Not yet implemented")
}

private fun isPossibleToCapturePawn(move: Move): Boolean {
    TODO("Not yet implemented")
}
