import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Move
import edu.austral.dissis.chess.game.MoveResultHandler

class ClassicMoveResultHandler : MoveResultHandler {
    override fun handleSingleMove(move: Move): Board {
        return move.board.move(move.from, move.to)
    }

    override fun handleMultipleMoves(move: Move): Board {
        TODO("Not yet implemented")
    }

}
