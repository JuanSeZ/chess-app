package edu.austral.dissis.checkers.utils


import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.piece.Color
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class IsCaptureTest {

    @Test
    fun isCaptureShouldReturnTrue() {
        val move = Move(pawnInCenterWithEnemyDiagonal(),Position(4, 4), Position(6, 6),Color.WHITE)
        assertTrue { isCapture(move) }
    }

    @Test
    fun isCaptureShouldReturnTrue2() {
        val move = Move(pawnInCenterWithEnemyDiagonal(),Position(4, 4), Position(2, 2),Color.WHITE)
        assertTrue { isCapture(move) }
    }

    @Test
    fun isCaptureShouldReturnTrue3() {
        val move = Move(pawnInCenterWithEnemyDiagonal(),Position(4, 4), Position(6, 2),Color.WHITE)
        assertTrue { isCapture(move) }
    }

    @Test
    fun isCaptureShouldReturnTrue4() {
        val move = Move(pawnInCenterWithEnemyDiagonal(),Position(4, 4), Position(2, 6),Color.WHITE)
        assertTrue { isCapture(move) }
    }

}
