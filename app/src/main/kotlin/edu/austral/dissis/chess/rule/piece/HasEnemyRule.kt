package rule.piece

import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.result.validation.InvalidResult
import edu.austral.dissis.common.result.validation.ValidResult
import result.validation.ValidationResult
import edu.austral.dissis.common.rule.Rule

class HasEnemyRule: Rule {
    override fun validate(move: Move): ValidationResult {
        move.board.getPieceAt(move.to)?.let {
            if (it.color != move.turn) return ValidResult
            else return InvalidResult("You can't eat your own pieces!")
        }
        return InvalidResult("You can't eat empty squares!")
    }
}
