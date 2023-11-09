package edu.austral.dissis.client

import edu.austral.dissis.chess.gui.*
import edu.austral.ingsis.clientserver.Client
import edu.austral.ingsis.clientserver.Message

class GameClient(val client: Client, val view: GameView) {

    fun receiveMove(message: Message<MoveResult>) {
        view.handleMoveResult(message.payload)
    }

    fun handleInitialState(message: Message<InitialState>) {
        view.handleInitialState(message.payload)
    }

    fun sendMove(move: Move) {
        client.send(Message("move", move))
    }
}
