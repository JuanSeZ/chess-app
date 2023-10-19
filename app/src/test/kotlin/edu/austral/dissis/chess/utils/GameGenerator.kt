package edu.austral.dissis.chess.utils

import board.Board
import edu.austral.dissis.chess.rule.game.CheckmateRule
import edu.austral.dissis.chess.rule.game.FriendlyFireRule
import game.Game
import piece.Color
import rule.Rule

fun generateTestGame(board: Board, globalRules: List<Rule>): Game{
    return Game(board, globalRules, Color.WHITE,FriendlyFireRule())
}
