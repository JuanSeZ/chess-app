package edu.austral.dissis.checkers.utils

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.piece.Piece

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

    return pieceNotNullAndEnemy(piece, move, toPiece)

}
fun isPossibleToCaptureAgain(move: Move): Boolean {
    val lastMove = move.history.last()
    val board = lastMove.board.move(lastMove.from, lastMove.to)
    val move = Move(board, lastMove.to, lastMove.to, lastMove.turn)
    return isPossibleToCapture(move)
}

fun isPossibleToCapture(move: Move): Boolean {
    return when (move.board.getBoard()[move.from]?.type?.getValue()){
        "pawn" -> isPossibleToCaptureForward(move)
        "king" -> isPossibleToCaptureBackwards(move) || isPossibleToCaptureForward(move)
        else -> false
    }
}


private fun isPossibleToCaptureBackwards(move: Move): Boolean {
    val orientation = if (isWhite(move)) 1 else -1
    val from = move.from

    return (isPossibleToCapture(move, from.column - 2, from.row + 2 * orientation) ||
            isPossibleToCapture(move, from.column + 2, from.row + 2 * orientation))
}

private fun isPossibleToCaptureForward(move: Move): Boolean {
    val orientation = if (isWhite(move)) -1 else 1
    val from = move.from

    return (isPossibleToCapture(move, from.column - 2, from.row + 2 * orientation) ||
            isPossibleToCapture(move, from.column + 2, from.row + 2 * orientation))
}

private fun isWhite(move: Move) = move.board.getBoard()[move.from]?.color == Color.WHITE

private fun isPossibleToCapture(move: Move, column: Int, row: Int): Boolean {
    val position = Position(column, row)
    if (isInRange(position, move)) return false
    val possibleMove = Move(move.board, move.from, position, move.turn)
    return isCapture(possibleMove)
}

private fun isInRange(
    position: Position,
    move: Move
) =
    position.row > move.board.getRowsSize() || position.column > move.board.getColumnsSize() || position.row < 1 || position.column < 1

fun lastMoveWasCapture(move: Move): Boolean {
    if(move.history.isEmpty()) return false
    if(move.history.last().turn != move.turn) return false
    return isCapture(move.history.last())
}

fun nextMoveIsPossibleToCapture(moves: List<Move>): Boolean {
    if(moves.isEmpty()) return false
    var possibleNextMove: Move
    if(isCapture(moves.last())) possibleNextMove = Move(removeAndMoveCapturedPiece(moves.last()), moves.last().to, moves.last().to, moves.last().turn)
    else possibleNextMove = Move(moves.last().board.move(moves.last().from,moves.last().to), moves.last().to, moves.last().to, moves.last().turn)
    return isPossibleToCapture(possibleNextMove)
}

fun removeAndMoveCapturedPiece(move: Move): Board {
    val from = move.from
    val to = move.to

    val rowDirection = if (to.row > from.row) 1 else -1
    val colDirection = if (to.column > from.column) 1 else -1

    var currentRow = from.row + rowDirection
    var currentCol = from.column + colDirection

    val currentPosition = Position(currentCol, currentRow)

    val piece = move.board.getPieceAt(currentPosition)
    val toPiece = move.board.getPieceAt(to)

    if (pieceNotNullAndEnemy(piece, move, toPiece)) {
        val newBoard = move.board.removePiece(currentPosition)
        return newBoard.move(from, to)
    }
    return move.board
}

private fun pieceNotNullAndEnemy(
    piece: Piece?,
    move: Move,
    toPiece: Piece?
) = piece != null && piece.color != move.turn && toPiece == null

fun isTheSamePiece(move: Move): Boolean {
    return move.from == move.history.last().to && move.history.last().turn == move.turn
}
