package edu.austral.dissis.chess.game

import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Move
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.result.game.EndGameResult
import piece.Color
import result.game.MoveResult
import edu.austral.dissis.chess.result.game.RuleViolationResult
import edu.austral.dissis.chess.result.game.UnsuccesfulMoveResult
import result.game.SuccesfulMoveResult
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import rule.Rule


class Game(
    private var board: Board,
    private val globalRules: List<Rule>,
    private val turn: Color,
    private val winningConditionRule: Rule

){
    fun move(from: Position, to: Position): MoveResult{
        val move = Move(board, from, to, turn)
        val globalValidationResult = validateGlobalRules(move)
        if (globalValidationResult is UnsuccesfulMoveResult) return globalValidationResult
        val pieceValidationResult = validatePieceRules(move)
        if (pieceValidationResult !is SuccesfulMoveResult ) return pieceValidationResult
        val winningConditionResult = winningConditionRule.validate(Move(board.move(from,to),from,to,turn))
        if (winningConditionResult is InvalidResult) return EndGameResult(turn)
        return pieceValidationResult
    }

    private fun validatePieceRules(move: Move): MoveResult {
        val piece = move.board.getPieceAt(move.from) ?: return RuleViolationResult()
        return when (val result = piece.rule.validate(move)) {
            is ValidResult -> executeMove(move)
            is InvalidResult -> UnsuccesfulMoveResult(result.getMessage())
            else -> RuleViolationResult()
        }
    }


    private fun validateGlobalRules(move: Move): MoveResult{
        for (rule in globalRules){
            when(val result = rule.validate(move)){
                is ValidResult -> continue
                is InvalidResult -> return UnsuccesfulMoveResult(result.getMessage())
            }
        }
        return SuccesfulMoveResult(this)
    }

    private fun executeMove(move: Move): MoveResult {
        val newBoard = move.board.move(move.from, move.to)
        return SuccesfulMoveResult(Game(newBoard, globalRules, getOppositeTurn(), winningConditionRule))
    }

    private fun getOppositeTurn(): Color {
        return when (turn) {
            Color.WHITE -> Color.BLACK
            Color.BLACK -> Color.WHITE
        }
    }

    fun getBoard(): Board {
        return board
    }

    fun getTurn(): Color {
        return turn
    }
}
