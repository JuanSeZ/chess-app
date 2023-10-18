package rule.game

import board.Move
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import result.validation.ValidationResult
import rule.Rule
import rule.utils.isInCheck
import rule.utils.possibleMoves

class CheckmateRule : Rule {
    override fun validate(move: Move): ValidationResult {
        if (isInCheck(move.board, move.turn)){
            val possibleMoves = possibleMoves(move.board, move.turn)
            for(possibleMove in possibleMoves){
                if (!isInCheck(possibleMove.board.move(move.from,move.to), move.turn)) return ValidResult
            }
            return InvalidResult()
        }
        return ValidResult
    }
}
