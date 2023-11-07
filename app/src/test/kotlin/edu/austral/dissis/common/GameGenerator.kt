package edu.austral.dissis.common

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.rule.game.FriendlyFireRule
import edu.austral.dissis.common.game.Game
import edu.austral.dissis.common.game.MoveExecutioner
import edu.austral.dissis.common.game.TurnManager
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.rule.Rule

fun generateTestGame(board: Board,moveExecutioner: MoveExecutioner, turnManager: TurnManager, globalRules: List<Rule>): Game {
    return Game(board, globalRules,moveExecutioner,turnManager, Color.WHITE, FriendlyFireRule())
}
