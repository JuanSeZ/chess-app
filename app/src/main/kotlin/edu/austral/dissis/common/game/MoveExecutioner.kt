package edu.austral.dissis.common.game

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.game.MoveResult

interface MoveExecutioner {
    fun executeMove(move: Move): Board
}
