package edu.austral.dissis.chess.rule.game

import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Move
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import piece.Color
import result.validation.ValidationResult
import rule.Rule

class AlternativeWinRule : Rule {
    override fun validate(move: Move): ValidationResult {
        val enemies = enemyPiecesPositions(move.board, move.turn)
        if(enemies.isEmpty()) return InvalidResult("You win!")
        return ValidResult
    }

    private fun enemyPiecesPositions(board: Board, turn: Color): List<Position> {
        return board.getOccupiedPositions().filter { board.getPieceAt(it)?.color != turn }
    }

}
