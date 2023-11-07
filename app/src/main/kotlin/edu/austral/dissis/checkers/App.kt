package edu.austral.dissis.checkers

/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */

import edu.austral.dissis.checkers.factory.CheckersPieceFactory
import edu.austral.dissis.checkers.factory.CheckersRuleFactory
import edu.austral.dissis.checkers.game.CheckersExecutioner
import edu.austral.dissis.checkers.game.CheckersTurnManager
import edu.austral.dissis.checkers.rule.ShouldCaptureRule
import edu.austral.dissis.checkers.start.CheckersStartingBoard
import edu.austral.dissis.common.adapter.ChessEngineAdapter
import edu.austral.dissis.chess.gui.CachedImageResolver
import edu.austral.dissis.chess.gui.DefaultImageResolver
import edu.austral.dissis.chess.gui.GameView
import edu.austral.dissis.common.game.Game
import javafx.application.Application
import javafx.application.Application.launch
import javafx.scene.Scene
import javafx.stage.Stage
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.rule.Rule
import edu.austral.dissis.common.rule.game.AlternativeWinRule
import edu.austral.dissis.common.rule.game.FriendlyFireRule
import edu.austral.dissis.common.rule.game.NotYourTurnRule


fun main() {
    launch(CheckersGameApplication::class.java)
}

class CheckersGameApplication : Application() {
    private val globalRules = listOf(
        FriendlyFireRule(),
        NotYourTurnRule(),
        ShouldCaptureRule()
    )
    private val gameEngine = ChessEngineAdapter(
        Game(
            CheckersStartingBoard(CheckersPieceFactory(CheckersRuleFactory())).generate(),
            globalRules,
            CheckersExecutioner(),
            CheckersTurnManager(),
            Color.WHITE,
            AlternativeWinRule(),
        )
    )
    private val imageResolver = CachedImageResolver(DefaultImageResolver())

    companion object {
        const val GameTitle = "Checkers"
    }

    override fun start(primaryStage: Stage) {
        primaryStage.title = GameTitle

        val root = GameView(gameEngine, imageResolver)
        primaryStage.scene = Scene(root)

        primaryStage.show()
    }
}
