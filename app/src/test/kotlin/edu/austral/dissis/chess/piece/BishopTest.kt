package edu.austral.dissis.chess.piece

import edu.austral.dissis.chess.game.ChessExecutioner
import edu.austral.dissis.chess.game.ChessTurnManager
import edu.austral.dissis.common.board.Position
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import edu.austral.dissis.common.result.game.SuccesfulMoveResult
import edu.austral.dissis.chess.utils.bishopInCenter
import edu.austral.dissis.common.generateTestGame

class BishopTest {
    @Test
    fun `should move diagonally`() {
        // Given
        val game = generateTestGame(
            bishopInCenter(),
            ChessExecutioner(),
            ChessTurnManager(),
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
            ChessExecutioner(),
            ChessTurnManager(),
            listOf()
        )
        assertTrue(game.move(Position(4,4), Position(4,5)) !is SuccesfulMoveResult)
    }
}
