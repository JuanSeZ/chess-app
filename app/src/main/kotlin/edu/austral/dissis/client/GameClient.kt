package edu.austral.dissis.client

import com.fasterxml.jackson.core.type.TypeReference
import edu.austral.dissis.chess.gui.*
import edu.austral.ingsis.clientserver.Client
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.netty.client.NettyClientBuilder
import java.net.InetSocketAddress

class GameClient() {
    private lateinit var client: Client
    private lateinit var view: GameView

    fun start(newView: GameView) {
        view = newView
        client = buildClient()
        client.connect()
        client.send(Message("initial-state", Unit))
        view.addListener(GameMoveEventListener(this))
    }

    fun receiveMove(message: Message<MoveResult>) {
        view.handleMoveResult(message.payload)
    }

    fun handleInitialState(message: Message<InitialState>) {
        view.handleInitialState(message.payload)
    }

    fun handleNewGameState(message: Message<NewGameState>) {
        view.handleMoveResult(message.payload)
    }

    fun handleInvalidMove(message: Message<InvalidMove>) {
        view.handleMoveResult(message.payload)
    }

    fun sendMove(move: Move) {
        client.send(Message("move", move))
    }

    fun connect() {
        client.connect()
    }

    fun disconnect() {
        client.closeConnection()
    }

    private fun buildClient(): Client {
        return NettyClientBuilder
            .createDefault()
            .withAddress(InetSocketAddress(8080))
            .addMessageListener(
                "initial-state",
                object : TypeReference<Message<InitialState>>() {},
                InitialStateListener(this)
            )
            .addMessageListener(
                "new-game-state",
                object : TypeReference<Message<NewGameState>>() {},
                NewGameStateListener(this)
            )
            .addMessageListener(
                "invalid-move",
                object : TypeReference<Message<InvalidMove>>() {},
                InvalidMoveListener(this)
            )
            .addMessageListener(
                "game-over",
                object : TypeReference<Message<GameOver>>() {},
                GameOverListener(this)
            )
            .build()
    }

    fun handleEndGame(message: Message<GameOver>) {
        view.handleMoveResult(message.payload)
    }

}
