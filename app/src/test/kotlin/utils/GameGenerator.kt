package utils

import board.Board
import game.Game
import piece.Color
import rule.Rule

fun generateTestGame(board: Board, globalRules: List<Rule>): Game{
    return Game(board, globalRules, Color.WHITE)
}
