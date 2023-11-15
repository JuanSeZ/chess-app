package edu.austral.dissis.chess.game

import edu.austral.dissis.chess.factory.piece.ClassicPieceFactory
import edu.austral.dissis.chess.factory.rule.ClassicRuleFactory
import edu.austral.dissis.chess.gui.ChessPiece
import edu.austral.dissis.chess.piece.ChessPieceType
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.game.MoveAction
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.piece.Piece

class ChessPawnPromotionAction : MoveAction {
    override fun appliesTo(move: Move): Boolean {
        val limit = if (move.board.getBoard()[move.from]?.color == Color.WHITE) move.board.getRowsSize() else 0
        return move.to.row == limit && move.board.getBoard()[move.from]?.type?.getValue() == "pawn"
    }

    override fun apply(move: Move): Board {
        val board = move.board
        val piece = board.getBoard()[move.from]
        val templatePiece = ClassicPieceFactory(ClassicRuleFactory()).createPiece(ChessPieceType.QUEEN, piece!!.color)
        val newPiece = Piece(templatePiece.type, templatePiece.color, templatePiece.rule, piece.getMoveCount(), piece.getId())

        return board.move(move.from, move.to).removePiece(move.to).addPiece(move.to, newPiece)
    }
}
