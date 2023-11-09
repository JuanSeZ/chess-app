package edu.austral.dissis.chess.game

import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Move
import edu.austral.dissis.common.game.MoveExecutioner
import edu.austral.dissis.common.piece.Color

class ChessExecutioner : MoveExecutioner {
    override fun executeMove(move: Move): Board {

//        1- Normal move
//        2- Pawn promotion
//        3- Castling


        if(isPawnPromotion(move)) {
            return pawnPromotion(move)
        }

        if(isCastling(move)) {
            return castling(move)
        }

        return normalMove(move)
    }

    private fun normalMove(move: Move): Board {
        return move.board.move(move.from, move.to)
    }

    private fun castling(move: Move): Board {
        TODO("Not yet implemented")
    }

    private fun pawnPromotion(move: Move): Board {
        TODO("Not yet implemented")
    }

    private fun isPawnPromotion(move: Move): Boolean {
        val limit = if (move.board.getBoard()[move.from]?.color == Color.WHITE) move.board.getRowsSize() else 0
        return move.to.row == limit && move.board.getBoard()[move.from]?.type?.getValue() == "pawn"
    }

    private fun isCastling(move: Move): Boolean {
//        TODO
        return false
    }



}
