package edu.austral.dissis.chess.utils

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.chess.rule.game.FriendlyFireRule
import edu.austral.dissis.common.game.Game
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.rule.Rule

fun generateTestGame(board: Board, globalRules: List<Rule>): Game {
    return Game(board, globalRules, Color.WHITE,FriendlyFireRule())
}
