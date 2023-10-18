package piece

import board.Position
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import result.game.SuccesfulMoveResult
import utils.generateTestGame
import utils.rookInCenter

class RookTest {

    @Test
    fun `should move vertically and horizontally`() {
        val game = generateTestGame(
            rookInCenter(),
            listOf()
        )
        assertTrue(game.move(Position(4,4), Position(4,5)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(5,4)) is SuccesfulMoveResult)
    }

    @Test
    fun `should not move diagonally`() {
        val game = generateTestGame(
            rookInCenter(),
            listOf()
        )
        assertTrue(game.move(Position(4,4), Position(5,5)) !is SuccesfulMoveResult)
    }
}
