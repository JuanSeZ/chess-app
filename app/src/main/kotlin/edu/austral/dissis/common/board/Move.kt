package edu.austral.dissis.common.board

import edu.austral.dissis.common.piece.Color

data class Move(val board: Board, val from: Position, val to: Position, val turn: Color, val history: List<Move> = emptyList()){}
