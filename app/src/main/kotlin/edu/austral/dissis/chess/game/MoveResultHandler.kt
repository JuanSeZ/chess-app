package edu.austral.dissis.chess.game

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move

interface MoveResultHandler {
    fun handleSingleMove(move: Move): Board
    fun handleMultipleMoves(move: Move): Board
}
