package edu.austral.dissis.client


import edu.austral.ingsis.clientserver.ClientConnectionListener

class ClientConnectionListenerImpl(val client: GameClient) : ClientConnectionListener {
    override fun handleConnection() {
        client.client.connect()
    }

    override fun handleConnectionClosed() {
        client.client.closeConnection()
    }
}
