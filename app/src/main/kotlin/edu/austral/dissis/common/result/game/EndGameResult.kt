package edu.austral.dissis.common.result.game

import piece.Color
import result.game.MoveResult


class EndGameResult(private val winner: Color) : MoveResult {
    fun getWinner(): Color {
        return winner
    }
}
