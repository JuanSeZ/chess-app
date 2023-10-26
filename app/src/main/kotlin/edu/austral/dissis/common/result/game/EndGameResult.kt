package edu.austral.dissis.common.result.game

import edu.austral.dissis.common.piece.Color


class EndGameResult(private val winner: Color) : MoveResult {
    fun getWinner(): Color {
        return winner
    }
}
