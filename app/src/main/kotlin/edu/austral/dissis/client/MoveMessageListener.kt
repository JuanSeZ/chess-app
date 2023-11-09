package edu.austral.dissis.client

import edu.austral.dissis.chess.gui.MoveResult
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

class MoveMessageListener(val client: GameClient) : MessageListener<MoveResult> {
    override fun handleMessage(message: Message<MoveResult>) {
        client.receiveMove(message)
    }
}
