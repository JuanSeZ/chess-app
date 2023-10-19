package edu.austral.dissis.chess.rule.game

import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Move
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import edu.austral.dissis.chess.rule.utils.*
import piece.Color
import result.validation.ValidationResult
import rule.Rule

class CheckmateRule(private val globalRules: List<Rule>) : Rule {
    override fun validate(move: Move): ValidationResult {
        val enemy = oppositeColor(move.turn)

        val enemyPiecesPositions = enemyPiecesPositions(move.board,enemy)

        for(position in enemyPiecesPositions){
            val possibleMoves = findPossibleMoves(position,move.board, globalRules)
            for(possibleMove in possibleMoves){
                if(!isCheckAfterMove(possibleMove)) return ValidResult
            }
        }
        return InvalidResult("Checkmate!")
    }

    private fun isCheckAfterMove(move: Move): Boolean {
        val newBoard = move.board.move(move.from,move.to)
        return isCheck(newBoard,move.turn)
    }


    private fun enemyPiecesPositions(board: Board, turn: Color): List<Position> {
        return board.getOccupiedPositions().filter { board.getPieceAt(it)?.color == turn }
    }

}
