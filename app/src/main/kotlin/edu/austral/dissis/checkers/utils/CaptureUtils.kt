package edu.austral.dissis.checkers.utils

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.piece.Color

fun isCapture(move: Move): Boolean {
    val from = move.from
    val to = move.to

    val rowDirection = if (to.row > from.row) 1 else -1
    val colDirection = if (to.column > from.column) 1 else -1

    var currentRow = from.row + rowDirection
    var currentCol = from.column + colDirection

    val currentPosition = Position(currentCol, currentRow)

    val piece = move.board.getPieceAt(currentPosition)

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
    val orientation = if (move.board.getBoard()[move.from]?.color == Color.WHITE) -1 else 1
    val from = move.from

//    Verify left backwards
    if (from.row - 2 * orientation >= 0 && from.column - 2 * orientation >= 0) {
        val currentPosition = Position(from.column - 2 * orientation, from.row - 2 * orientation)
        val piece = move.board.getPieceAt(currentPosition)
        if (piece != null && piece.color != move.turn && move.board.getPieceAt(Position(from.column - orientation, from.row - orientation)) == null) {
            return true
        }
    }

//    Verify right backwards
    if (from.row - 2 * orientation >= 0 && from.column + 2 * orientation <= 7) {
        val currentPosition = Position(from.column + 2 * orientation, from.row - 2 * orientation)
        val piece = move.board.getPieceAt(currentPosition)
        if (piece != null && piece.color != move.turn && move.board.getPieceAt(Position(from.column + orientation, from.row - orientation)) == null) {
            return true
        }
    }
    return false
}

private fun isPossibleToCapturePawn(move: Move): Boolean {
    val orientation = if (move.board.getBoard()[move.from]?.color == Color.WHITE) 1 else -1
    val from = move.from

//    Verify left forward
    if (from.row + 2 * orientation <= move.board.getRowsSize() && from.column - 2 * orientation >= 0) {
        val currentPosition = Position(from.column - 2 * orientation, from.row + 2 * orientation)
        val piece = move.board.getPieceAt(currentPosition)
        if (piece != null && piece.color != move.turn && move.board.getPieceAt(Position(from.column - orientation, from.row + orientation)) == null) {
            return true
        }
    }

//    Verify right forward
    if (from.row + 2 * orientation <= move.board.getRowsSize() && from.column + 2 * orientation <= 7) {
        val currentPosition = Position(from.column + 2 * orientation, from.row + 2 * orientation)
        val piece = move.board.getPieceAt(currentPosition)
        if (piece != null && piece.color != move.turn && move.board.getPieceAt(Position(from.column + orientation, from.row + orientation)) == null) {
            return true
        }
    }
    return false
}
