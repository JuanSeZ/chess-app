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
    val toPiece = move.board.getPieceAt(to)

    return piece != null && piece.color != move.turn && toPiece == null

}

fun isPossibleToCapture(move: Move): Boolean {
    return when (move.board.getBoard()[move.from]?.type?.getValue()){
        "pawn" -> isPossibleToCapturePawn(move)
        "king" -> isPossibleToCaptureKing(move) && isPossibleToCapturePawn(move)
        else -> false
    }
}

private fun isPossibleToCaptureKing(move: Move): Boolean {
//    TODO() Verify
    val orientation = if (move.board.getBoard()[move.from]?.color == Color.WHITE) 1 else -1
    val from = move.from

//    Verify left
    val possibleLeft = Position(from.column - 2 , from.row + 2 * orientation)
    val possibleLeftMove = Move(move.board, from, possibleLeft, move.turn)
    if(isCapture(possibleLeftMove)){
        return true
    }

//    Verify right
    val possibleRight = Position(from.column + 2 , from.row + 2 * orientation)
    val possibleRightMove = Move(move.board, from, possibleRight, move.turn)

    return isCapture(possibleRightMove)

}

private fun isPossibleToCapturePawn(move: Move): Boolean {
    val orientation = if (move.board.getBoard()[move.from]?.color == Color.WHITE) -1 else 1
    val from = move.from

//    Verify left
    val possibleLeft = Position(from.column - 2 , from.row + 2 * orientation)
    val possibleLeftMove = Move(move.board, from, possibleLeft, move.turn)
    if (isCapture(possibleLeftMove)) {return true}

//    Verify right
    val possibleRight = Position(from.column + 2 , from.row + 2 * orientation)
    val possibleRightMove = Move(move.board, from, possibleRight, move.turn)



    return isCapture(possibleRightMove)
}
fun lastMoveWasCapture(move: Move): Boolean {
    if(move.history.isEmpty()) return false
    return isCapture(move.history.last())
}

fun nextMoveIsPossibleToCapture(moves: List<Move>): Boolean {
    if(moves.isEmpty()) return false
    val possibleNextMove = Move(moves.last().board.move(moves.last().from,moves.last().to), moves.last().to, moves.last().to, moves.last().turn)
    return isPossibleToCapture(possibleNextMove)
}
