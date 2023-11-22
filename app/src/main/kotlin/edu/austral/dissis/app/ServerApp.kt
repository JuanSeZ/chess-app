package edu.austral.dissis.app

import edu.austral.dissis.chess.factory.piece.ClassicPieceFactory
import edu.austral.dissis.chess.factory.rule.ClassicRuleFactory
import edu.austral.dissis.chess.game.ChessCastlingAction
import edu.austral.dissis.chess.game.ChessNormalAction
import edu.austral.dissis.chess.game.ChessPawnPromotionAction
import edu.austral.dissis.chess.game.ChessTurnManager
import edu.austral.dissis.chess.rule.game.CheckRule
import edu.austral.dissis.chess.rule.game.CheckmateRule
import edu.austral.dissis.chess.start.ClassicStartingBoard
import edu.austral.dissis.common.game.Executioner
import edu.austral.dissis.common.game.Game
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.rule.game.FriendlyFireRule
import edu.austral.dissis.common.rule.game.NotYourTurnRule
import edu.austral.dissis.server.GameServer

fun main() {

    val globalRules = listOf(
        FriendlyFireRule(),
        NotYourTurnRule(),
        CheckRule()
    )
    val game = Game(
        ClassicStartingBoard(ClassicPieceFactory(ClassicRuleFactory())).generate(),
        globalRules,
        Executioner(listOf(ChessPawnPromotionAction(), ChessCastlingAction(), ChessNormalAction())),
        ChessTurnManager(),
        Color.WHITE,
        CheckmateRule(globalRules),
    )

    GameServer(game)
}
