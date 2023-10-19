package edu.austral.dissis.chess.utils

import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.rule.game.FriendlyFireRule
import edu.austral.dissis.chess.game.Game
import piece.Color
import rule.Rule

fun generateTestGame(board: Board, globalRules: List<Rule>): Game {
    return Game(board, globalRules, Color.WHITE,FriendlyFireRule())
}
