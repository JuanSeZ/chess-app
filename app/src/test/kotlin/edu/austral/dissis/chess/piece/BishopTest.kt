package edu.austral.dissis.chess.piece

import board.Position
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import result.game.SuccesfulMoveResult
import edu.austral.dissis.chess.utils.bishopInCenter
import edu.austral.dissis.chess.utils.generateTestGame

class BishopTest {
    @Test
    fun `should move diagonally`() {
        // Given
        val game = generateTestGame(
            bishopInCenter(),
            listOf()
        )
        assertTrue(game.move(Position(4,4), Position(5,5)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(6,6)) is SuccesfulMoveResult)
    }

    @Test
    fun `should not move vertically`(){
        // Given
        val game = generateTestGame(
            bishopInCenter(),
            listOf()
        )
        assertTrue(game.move(Position(4,4), Position(4,5)) !is SuccesfulMoveResult)
    }
}
