package edu.austral.dissis.client

import edu.austral.dissis.chess.gui.NewGameState
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener
import javafx.application.Platform

class NewGameStateListener(val gameClient: GameClient) : MessageListener<NewGameState> {
    override fun handleMessage(message: Message<NewGameState>) {
            gameClient.handleNewGameState(message)
    }
}
