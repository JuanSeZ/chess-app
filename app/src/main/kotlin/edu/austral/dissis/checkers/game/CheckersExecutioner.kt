package edu.austral.dissis.checkers.game

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.game.MoveExecutioner

class CheckersExecutioner: MoveExecutioner {
    override fun executeMove(move: Move): Board {
        if(isCapture()){
            return capture(move)
        }
        return normalMove(move)
    }

    private fun normalMove(move: Move): Board {
        return move.board.move(move.from, move.to)
    }

    private fun capture(move: Move): Board {
//        Move the piece to the new position and remove the piece in between them
        TODO()
    }

    private fun isCapture(): Boolean {
        TODO()
        return false
    }
}
