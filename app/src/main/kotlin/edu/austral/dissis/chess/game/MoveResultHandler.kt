package edu.austral.dissis.chess.game

import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Move

interface MoveResultHandler {
    fun handleSingleMove(move: Move): Board
    fun handleMultipleMoves(move: Move): Board
}
