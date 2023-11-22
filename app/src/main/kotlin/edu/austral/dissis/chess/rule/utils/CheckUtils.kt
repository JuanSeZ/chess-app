package edu.austral.dissis.chess.rule.utils

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.rule.Rule

 fun findPossibleMoves(piecePosition: Position, board: Board, gameRules: List<Rule>): List<Move>{
    val piece = board.getPieceAt(piecePosition) ?: throw NoSuchElementException("No piece found")
    val team = piece.color
    var validMoves = emptyList<Move>()
    for(i in 1..board.getRowsSize()){
        validMoves = getPossibleMoves(board, i, piecePosition, team, validMoves, piece, gameRules)
    }
    return validMoves
}

private fun getPossibleMoves(
    board: Board,
    i: Int,
    piecePosition: Position,
    team: Color,
    validMoves: List<Move>,
    piece: Piece,
    gameRules: List<Rule>
): List<Move> {
    var validMoves1 = validMoves
    for (j in 1..board.getColumnsSize()) {
        val to = Position(i, j)
        val move = Move(board, piecePosition, to, team)
        validMoves1 = moveList(piece, move, gameRules, validMoves1)
    }
    return validMoves1
}

private fun moveList(
    piece: Piece,
    move: Move,
    gameRules: List<Rule>,
    validMoves: List<Move>
): List<Move> {
    var validMoves1 = validMoves
    if (isValid(piece, move, gameRules)) {
        validMoves1 = validMoves1.plus(move)
    }
    return validMoves1
}

private fun isValid(
    piece: Piece,
    move: Move,
    gameRules: List<Rule>
) = piece.rule.validate(move) is ValidResult && gameRules.all { it.validate(move) is ValidResult }

fun isInCheckAfterMove(move: Move): Boolean {
    val newBoard = move.board.move(move.from,move.to)
    return isCheck(newBoard,move.turn)
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
        if (isKingAndTurn(piece, turn)) return position
    }
    return null
}

private fun isKingAndTurn(
    piece: Piece,
    turn: Color
) = piece.type.getValue() == "king" && piece.color == turn

fun oppositeColor(turn: Color): Color {
    return when (turn) {
        Color.WHITE -> Color.BLACK
        Color.BLACK -> Color.WHITE
    }
}

fun attacksKing(board: Board, position: Position, turn: Color, kingsPosition: Position): Boolean {
    if (isPieceIsEnemy(board, position, turn)) {
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

private fun isPieceIsEnemy(
    board: Board,
    position: Position,
    turn: Color
) = board.getPieceAt(position)?.color != turn


