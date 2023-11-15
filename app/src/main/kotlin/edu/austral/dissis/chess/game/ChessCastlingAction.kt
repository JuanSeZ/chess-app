package edu.austral.dissis.chess.game

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.game.MoveAction

class ChessCastlingAction: MoveAction {
    override fun appliesTo(move: Move): Boolean {
//        1- There's must not be any pieces between the king and the rook
//        2- The king and the rook must not have moved
//        3- The king must not be in check
//        4- The king must not move through a square that is attacked by an enemy piece
//        5- The king must not end up in check
        return false
    }

    override fun apply(move: Move): Board {
        return move.board.move(move.from, move.to)
    }
}
