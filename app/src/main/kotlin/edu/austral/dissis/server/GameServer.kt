package edu.austral.dissis.server


import edu.austral.dissis.chess.gui.*
import edu.austral.dissis.common.adapter.convertToChessPieces
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.Game
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.result.game.EndGameResult
import edu.austral.dissis.common.result.game.SuccesfulMoveResult
import edu.austral.dissis.common.result.game.UnsuccesfulMoveResult
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.Server

class GameServer(val server: Server,private val game: Game) {

    fun handleMove(move: Move){
        val (from, to) = transformMove(move)

        when (val result = game.move(from,to)){
            is SuccesfulMoveResult -> {
                server.broadcast(Message("move",handleNewGameState(result)))
            }
            is UnsuccesfulMoveResult -> {
                server.broadcast(Message("invalidMove",result.getMessage()))
            }
            is EndGameResult -> {
                server.broadcast(Message("endGame",result.getWinner()))
            }
        }
    }

    private fun transformMove(move: Move): Pair<Position, Position> {
        val from = Position(move.from.column,move.from.row)
        val to = Position(move.to.column,move.to.row)
        return Pair(from,to)
    }

    fun handleInitialConnection(clientId: String){
        val boardSize = BoardSize(game.getBoard().getColumnsSize(),game.getBoard().getRowsSize())
        val pieces = convertToChessPieces(game.getBoard().getOccupiedPositions(),game.getBoard())
        val color = when (game.getTurn()){
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }
        server.sendMessage(clientId,Message("initialState",InitialState(boardSize,pieces,color)))
    }

    private fun handleNewGameState(result: SuccesfulMoveResult): MoveResult{
        val pieces = convertToChessPieces(result.game.getBoard().getOccupiedPositions(),result.game.getBoard())
        val color = when (game.getNextTurn()){
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }
        return NewGameState(pieces,color)
    }


}
