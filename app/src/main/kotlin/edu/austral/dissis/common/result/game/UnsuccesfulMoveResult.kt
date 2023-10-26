package edu.austral.dissis.common.result.game

class UnsuccesfulMoveResult(private val message: String) : MoveResult {
     fun getMessage(): String {
        return message
    }
}
