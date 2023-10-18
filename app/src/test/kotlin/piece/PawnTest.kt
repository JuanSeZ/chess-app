package piece

import board.Position
import junit.framework.TestCase.assertTrue
import org.junit.jupiter.api.Test
import result.game.SuccesfulMoveResult
import utils.generateTestGame
import utils.pawnInCenter

class PawnTest {

    @Test
    fun `should move one step forward`() {
        // Given
        val game = generateTestGame(
            pawnInCenter(),
            listOf()
        )
        assertTrue(game.move(Position(4,4), Position(4,5)) is SuccesfulMoveResult)
    }
}
