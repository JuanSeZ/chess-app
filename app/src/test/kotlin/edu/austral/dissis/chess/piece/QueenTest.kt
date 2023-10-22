package edu.austral.dissis.chess.piece

import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.utils.blackQueenInPlace
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import edu.austral.dissis.common.result.game.SuccesfulMoveResult
import edu.austral.dissis.chess.utils.generateTestGame
import edu.austral.dissis.chess.utils.queenInCenter

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

    @Test
    fun `should multiple diagonal`(){
        val game = generateTestGame(
            blackQueenInPlace(),
            listOf()
        )
        assertTrue(game.move(Position(4,1), Position(8,5)) is SuccesfulMoveResult)
    }
}
