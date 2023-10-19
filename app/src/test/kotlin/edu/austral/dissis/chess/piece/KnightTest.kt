package edu.austral.dissis.chess.piece

import edu.austral.dissis.chess.board.Position
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import result.game.SuccesfulMoveResult
import edu.austral.dissis.chess.utils.generateTestGame
import edu.austral.dissis.chess.utils.knightInCenter
import edu.austral.dissis.chess.utils.knightInCenterWithEnemyInL

class KnightTest {

    @Test
    fun `should move in l`(){
        // Given
        val game = generateTestGame(
            knightInCenter(),
            listOf()
        )

        assertTrue(game.move(Position(4,4), Position(5,6)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(6,5)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(6,3)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(5,2)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(3,2)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(2,3)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(2,5)) is SuccesfulMoveResult)
        assertTrue(game.move(Position(4,4), Position(3,6)) is SuccesfulMoveResult)
    }

    @Test
    fun `eats in L`() {
        val game = generateTestGame(
            knightInCenterWithEnemyInL(),
            listOf()
        )

        assertTrue(game.move(Position(4,4), Position(5,6)) is SuccesfulMoveResult)
    }
}
