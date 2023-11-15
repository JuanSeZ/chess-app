package edu.austral.dissis.checkers.game

import edu.austral.dissis.checkers.utils.isCapture
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.MoveAction
import edu.austral.dissis.common.game.MoveExecutioner


class CheckersExecutioner(private val actions: List<MoveAction>): MoveExecutioner {
    override fun executeMove(move: Move): Board {
        for (action in actions) {
            if (action.appliesTo(move)) {
                return action.apply(move)
            }
        }
        return move.board
    }




}
