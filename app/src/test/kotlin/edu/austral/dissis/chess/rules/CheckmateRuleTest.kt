package edu.austral.dissis.chess.rules

import board.Move
import board.Position
import edu.austral.dissis.chess.result.validation.InvalidResult
import edu.austral.dissis.chess.result.validation.ValidResult
import edu.austral.dissis.chess.utils.kingIsInCheck
import org.junit.jupiter.api.Test
import piece.Color
import edu.austral.dissis.chess.rule.game.CheckRule
import edu.austral.dissis.chess.rule.game.CheckmateRule
import edu.austral.dissis.chess.utils.kingIsInCheckmate
import kotlin.test.assertTrue

class CheckmateRuleTest {

    @Test
    fun `should return invalid`() {
        val board = kingIsInCheckmate()
        val rule = CheckmateRule(listOf())
        val move = Move(board, Position(1,1),Position(3,1),Color.WHITE)
        assertTrue { rule.validate(move) is InvalidResult }
    }

    @Test
    fun `should return valid`() {
        val board = kingIsInCheck()
        val rule = CheckmateRule(listOf())
        val move = Move(board, Position(1,1),Position(3,1),Color.WHITE)
        assertTrue { rule.validate(move) is ValidResult }
    }
}
