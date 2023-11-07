package edu.austral.dissis.checkers.rule

import edu.austral.dissis.checkers.utils.isPossibleToCapture
import edu.austral.dissis.checkers.utils.lastMoveWasCapture
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import edu.austral.dissis.common.result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class SamePawnShouldMoveRule : Rule {
    private fun isNotSamePawn(move: Move): Boolean {
        return move.board.getPieceAt(move.from) != move.history.last().board.getPieceAt(move.from)
    }

    override fun validate(move: Move): ValidationResult {
        if(move.history.isNotEmpty()) {
            println("Last move was capture")
            println(lastMoveWasCapture(move))
            println("Is possible to capture")
            println(isPossibleToCapture(move))
            println("Is not same pawn")
            println(this.isNotSamePawn(move))
        }
        if(move.history.isNotEmpty() && lastMoveWasCapture(move) && isPossibleToCapture(move) && this.isNotSamePawn(move)) {
            return InvalidResult("You must use the same pawn to capture")
        }
        return ValidResult
    }

}
