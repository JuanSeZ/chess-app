package edu.austral.dissis.chess.piece

import edu.austral.dissis.chess.game.ChessExecutioner
import edu.austral.dissis.chess.game.ChessTurnManager
import edu.austral.dissis.common.board.Position
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import edu.austral.dissis.common.result.game.SuccesfulMoveResult
import edu.austral.dissis.common.generateTestGame
import edu.austral.dissis.chess.utils.pawnInCenter
import edu.austral.dissis.chess.utils.pawnInCenterWithEnemyDiagonal

class PawnTest {

    @Test
    fun `should move one step forward`() {
        val game = generateTestGame(
            pawnInCenter(),
            ChessExecutioner(),
            ChessTurnManager(),
            listOf()
        )
        Assertions.assertTrue(game.move(Position(4,4), Position(4,5)) is SuccesfulMoveResult)
    }

    @Test
    fun `should not move diagonally` () {
        val game = generateTestGame(
            pawnInCenter(),
            ChessExecutioner(),
            ChessTurnManager(),
            listOf()
        )
        Assertions.assertTrue(game.move(Position(4,4), Position(5,5)) !is SuccesfulMoveResult)
    }

    @Test
    fun `should move diagonally` () {
        val game = generateTestGame(
            pawnInCenterWithEnemyDiagonal(),
            ChessExecutioner(),
            ChessTurnManager(),
            listOf()
        )
        Assertions.assertTrue(game.move(Position(4,4), Position(5,5)) is SuccesfulMoveResult)
    }

}
