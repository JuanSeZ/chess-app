package edu.austral.dissis.server


import com.fasterxml.jackson.core.type.TypeReference
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
import edu.austral.ingsis.clientserver.ServerBuilder
import edu.austral.ingsis.clientserver.netty.server.NettyServerBuilder

class GameServer(private var game: Game,private val serverBuilder: ServerBuilder = NettyServerBuilder.createDefault()) {

    private val server: Server
    init {
        server = buildServer()
        server.start()
    }

    fun handleMove(move: Move){
        val (from, to) = transformMove(move)

        when (val result = game.move(from,to)){
            is SuccesfulMoveResult -> {
                server.broadcast(Message("new-game-state",handleNewGameState(result)))
            }
            is UnsuccesfulMoveResult -> {
                server.broadcast(Message("invalid-move",InvalidMove(result.getMessage())))
            }
            is EndGameResult -> {
                server.broadcast(Message("game-over",GameOver(handleColor(result.getWinner()))))
            }
        }
    }

    fun stop(){
        server.stop()
    }

    private fun transformMove(move: Move): Pair<Position, Position> {
        val from = Position(move.from.column,move.from.row)
        val to = Position(move.to.column,move.to.row)
        return Pair(from,to)
    }

    fun handleInitialConnection(){
        val boardSize = BoardSize(game.getBoard().getColumnsSize(),game.getBoard().getRowsSize())
        val pieces = convertToChessPieces(game.getBoard().getOccupiedPositions(),game.getBoard())
        val color = when (game.getTurn()){
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }
        server.broadcast(Message("initial-state",InitialState(boardSize,pieces,color)))
    }

    private fun handleNewGameState(result: SuccesfulMoveResult): MoveResult{
        game = result.game
        val pieces = convertToChessPieces(result.game.getBoard().getOccupiedPositions(),result.game.getBoard())
        val color = when (game.getNextTurn()){
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }
        return NewGameState(pieces,color)
    }

    private fun buildServer(): Server{
        return serverBuilder
            .withPort(8080)
            .addMessageListener("initial-state",
                object : TypeReference<Message<Unit>>() {},
                InitListener(this))
            .addMessageListener(
                "move",
                object : TypeReference<Message<Move>> () {},
                MoveMessageListener(this)
            )
            .build()
    }

    private fun handleColor(color: Color): PlayerColor {
        return when (color){
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }
    }
}
