package edu.austral.dissis.server

import edu.austral.ingsis.clientserver.ServerConnectionListener

class ServerConnectionListenerImpl(private val server: GameServer) : ServerConnectionListener {
    override fun handleClientConnection(clientId: String) {
        server.handleInitialConnection(clientId)
    }

    override fun handleClientConnectionClosed(clientId: String) {
        server.server.stop()
    }
}
