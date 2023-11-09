package edu.austral.dissis.client

import edu.austral.dissis.chess.gui.InitialState
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener
import javafx.application.Platform

class InitialStateListener(private val client: GameClient) : MessageListener<InitialState> {
    override fun handleMessage(message: Message<InitialState>) {
        client.handleInitialState(message)
    }
}
