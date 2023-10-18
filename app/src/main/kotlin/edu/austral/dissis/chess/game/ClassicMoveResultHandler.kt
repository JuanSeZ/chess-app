import board.Board
import board.Move
import game.MoveResultHandler

class ClassicMoveResultHandler : MoveResultHandler{
    override fun handleSingleMove(move: Move): Board {
        return move.board.move(move.from, move.to)
    }

    override fun handleMultipleMoves(move: Move): Board {
        TODO("Not yet implemented")
    }

}
