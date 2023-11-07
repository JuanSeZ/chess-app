package edu.austral.dissis.chess.piece

import edu.austral.dissis.checkers.game.CheckersTurnManager
import edu.austral.dissis.chess.game.ChessExecutioner
import edu.austral.dissis.common.board.Position
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import edu.austral.dissis.common.result.game.SuccesfulMoveResult
import edu.austral.dissis.common.generateTestGame
import edu.austral.dissis.chess.utils.knightInCenter
import edu.austral.dissis.chess.utils.knightInCenterWithEnemyInL

class KnightTest {

    @Test
    fun `should move in l`(){
        // Given
        val game = generateTestGame(
            knightInCenter(),
            ChessExecutioner(),
            CheckersTurnManager(),
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
            ChessExecutioner(),
            CheckersTurnManager(),
            listOf()
        )

        assertTrue(game.move(Position(4,4), Position(5,6)) is SuccesfulMoveResult)
    }
}
