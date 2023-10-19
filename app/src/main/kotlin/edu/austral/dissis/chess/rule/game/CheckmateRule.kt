package edu.austral.dissis.chess.rule.game

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import edu.austral.dissis.chess.rule.utils.enemyPiecesPositions
import result.validation.ValidationResult
import rule.Rule
import edu.austral.dissis.chess.rule.utils.isInCheck
import edu.austral.dissis.chess.rule.utils.isInCheckAfterMove
import edu.austral.dissis.chess.rule.utils.possibleMoves

class CheckmateRule(private val globalRules: List<Rule>) : Rule {
    override fun validate(move: Move): ValidationResult {
        val enemyPiecesPositions = enemyPiecesPositions(move.board, move.turn)

        for(position in enemyPiecesPositions){
            val possibleMoves = possibleMoves(position,move.board, globalRules)
            for(possibleMove in possibleMoves){
                if(!isInCheckAfterMove(move)) return ValidResult
            }
        }
        return InvalidResult("Checkmate!")
    }
}
