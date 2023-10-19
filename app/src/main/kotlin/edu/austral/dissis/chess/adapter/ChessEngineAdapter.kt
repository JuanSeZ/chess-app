package edu.austral.dissis.chess.adapter

import board.Board
import board.Position
import edu.austral.dissis.chess.gui.*
import edu.austral.dissis.chess.result.game.EndGameResult
import game.Game
import piece.Color
import piece.PieceType
import edu.austral.dissis.chess.result.game.UnsuccesfulMoveResult
import result.game.SuccesfulMoveResult

class ChessEngineAdapter(var game: Game): GameEngine {
    override fun applyMove(move: Move): MoveResult {
        val from = Position(move.from.column, move.from.row)
        val to = Position(move.to.column, move.to.row)
        return when (val result = game.move(from, to)) {
            is SuccesfulMoveResult -> convertSuccessResult(result)
            is UnsuccesfulMoveResult -> InvalidMove(result.getMessage())
            is EndGameResult -> GameOver(getTurn(result.getWinner()))
            else -> InvalidMove("Invalid move")
        }
    }

    override fun init(): InitialState {
        return InitialState(getBoardSize(), getPieces(), getTurn(game.getTurn()))
    }

    private fun getBoardSize(): BoardSize {
        val board = game.getBoard()
        return BoardSize(board.getColumnsSize(), board.getRowsSize())
    }

    private fun convertSuccessResult(result: SuccesfulMoveResult): MoveResult {
        game = result.game
        return NewGameState(getPieces(), getTurn(game.getTurn()))
    }

    private fun getPieces(): List<ChessPiece> {
        val board = game.getBoard()
        return convertToChessPieces(board.getOccupiedPositions(),board)
    }

    private fun getTurn(color: Color): PlayerColor {
        return when (color) {
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }
    }

    private fun convertToChessPieces(positions: List<Position>, board: Board): List<ChessPiece> {
        return positions.map { position ->
            val piece = board.getPieceAt(position)!!
            val color = when (piece.color) {
                Color.WHITE -> PlayerColor.WHITE
                Color.BLACK -> PlayerColor.BLACK
            }
            val type = when (piece.type) {
                PieceType.PAWN -> "pawn"
                PieceType.ROOK -> "rook"
                PieceType.KNIGHT -> "knight"
                PieceType.BISHOP -> "bishop"
                PieceType.QUEEN -> "queen"
                PieceType.KING -> "king"
            }
            val coordinate = edu.austral.dissis.chess.gui.Position(position.row, position.column)

            ChessPiece(piece.getId(),color,coordinate,type)
        }
    }
}
