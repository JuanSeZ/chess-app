package edu.austral.dissis.common.result.game

import result.game.MoveResult

class UnsuccesfulMoveResult(private val message: String) : MoveResult {
     fun getMessage(): String {
        return message
    }
}
