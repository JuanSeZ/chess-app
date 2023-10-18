package game

import board.Board
import board.Move
import board.Position
import piece.Color
import result.game.MoveResult
import result.game.RuleViolationResult
import result.game.SuccesfulMoveResult
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import rule.Rule


class Game(
    private var board: Board,
    private val globalRules: List<Rule>,
    private val turn: Color

){
    fun move(from: Position, to: Position): MoveResult{
        val move: Move = Move(board, from, to, turn)
        val globalValidationResult = validateGlobalRules(move)
        if (globalValidationResult is RuleViolationResult) return globalValidationResult
        val pieceValidationResult = validatePieceRules(move)
        if (pieceValidationResult is RuleViolationResult) return pieceValidationResult
//      TODO: Verify checkmate
        return pieceValidationResult
    }

    private fun validatePieceRules(move: Move): MoveResult {
        val piece = move.board.getPieceAt(move.from) ?: return RuleViolationResult()
        return when (piece.rule.validate(move)) {
            is ValidResult -> SuccesfulMoveResult()
            is InvalidResult -> RuleViolationResult()
            else -> RuleViolationResult()
        }
    }


    private fun validateGlobalRules(move: Move): MoveResult{
        for (rule in globalRules){
            when(rule.validate(move)){
                is ValidResult -> continue
                is InvalidResult -> return RuleViolationResult()
            }
        }
        return SuccesfulMoveResult()
    }
}
