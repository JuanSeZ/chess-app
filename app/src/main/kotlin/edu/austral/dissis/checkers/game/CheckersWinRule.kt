package edu.austral.dissis.checkers.game

import edu.austral.dissis.checkers.utils.isCapture
import edu.austral.dissis.checkers.utils.removeAndMoveCapturedPiece
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class CheckersWinRule : Rule {
    override fun validate(move: Move): ValidationResult {
        val nextBoard : Board
        if (isCapture(move)) { nextBoard = removeAndMoveCapturedPiece(move) }
        else { nextBoard = move.board.move(move.from, move.to) }
        val enemies = enemyPiecesPositions(nextBoard, move.turn)
        if(enemies.isEmpty()) return InvalidResult("You win!")
        return ValidResult
    }

    private fun enemyPiecesPositions(board: Board, turn: Color): List<Position> {
        return board.getOccupiedPositions().filter { board.getPieceAt(it)?.color != turn }
    }

}
