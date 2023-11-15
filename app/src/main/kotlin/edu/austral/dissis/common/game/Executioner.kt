package edu.austral.dissis.common.game

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move

class Executioner(private val actions: List<MoveAction>) : MoveExecutioner {
    override fun executeMove(move: Move): Board {
        for (action in actions) {
            if (action.appliesTo(move)) {
                return action.apply(move)
            }
        }
        return move.board
    }
}
