package edu.austral.dissis.checkers.game

import edu.austral.dissis.checkers.factory.CheckersPieceFactory
import edu.austral.dissis.checkers.factory.CheckersRuleFactory
import edu.austral.dissis.checkers.piece.CheckersPieceType
import edu.austral.dissis.checkers.utils.isCapture
import edu.austral.dissis.checkers.utils.removeAndMoveCapturedPiece
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.game.MoveAction
import edu.austral.dissis.common.piece.Color
import edu.austral.dissis.common.piece.Piece

class CheckersPromotionAction: MoveAction {
    override fun appliesTo(move: Move): Boolean {
        val orientation = if (move.board.getBoard()[move.from]?.color == Color.WHITE) -1 else 1
        return (move.to.row == 1 && orientation == -1) || (move.to.row == move.board.getRowsSize() && orientation == 1)
    }

    override fun apply(move: Move): Board {
        val board = move.board
        val piece = board.getBoard()[move.from]
        val templatePiece = CheckersPieceFactory(CheckersRuleFactory()).createPiece(CheckersPieceType.KING, piece!!.color)
        val newPiece = Piece(templatePiece.type, templatePiece.color, templatePiece.rule,piece.getMoveCount(),piece.getId())

        if(isCapture(move)) {
            return removeAndMoveCapturedPiece(move).removePiece(move.to).addPiece(move.to, newPiece)
        }

        return board.move(move.from, move.to).removePiece(move.to).addPiece(move.to, newPiece)
    }
}
