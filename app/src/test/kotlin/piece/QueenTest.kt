package piece

import board.Position
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import result.game.SuccesfulMoveResult
import utils.generateTestGame
import utils.queenInCenter
import utils.queenInCenterWithFriendlyInDiagonal

class QueenTest {
    @Test
    fun `should move diagonally`() {
        // Given
        val game = generateTestGame(
            queenInCenter(),
            listOf()
        )
        assertTrue(game.move(Position(4,4), Position(5,5)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(8,8)) is SuccesfulMoveResult)
    }

    @Test
    fun `should move vertically and horizontally`() {
        val game = generateTestGame(
            queenInCenter(),
            listOf()
        )
        assertTrue(game.move(Position(4,4), Position(4,8)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(8,4)) is SuccesfulMoveResult)
    }
}
