package edu.austral.dissis.chess.piece

import board.Position
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import result.game.SuccesfulMoveResult
import edu.austral.dissis.chess.utils.generateTestGame
import edu.austral.dissis.chess.utils.pawnInCenter

class KingTest {

    @Test
    fun `should move one step forward`() {
        val game = generateTestGame(
            pawnInCenter(),
            listOf()
        )
        assertTrue(game.move(Position(4,4), Position(4,5)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(6,6)) !is SuccesfulMoveResult)
    }

}
