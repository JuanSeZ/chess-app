package game

import board.Board
import board.Move

interface MoveResultHandler {
    fun handleSingleMove(move: Move): Board
    fun handleMultipleMoves(move: Move): Board
}
