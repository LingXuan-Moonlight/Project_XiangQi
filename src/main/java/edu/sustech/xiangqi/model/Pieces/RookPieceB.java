package edu.sustech.xiangqi.model.Pieces;

// 黑车

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

public class RookPieceB extends Piece {
    public RookPieceB() {
        super("车", false);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        //TODO:other piece has blocked the path

        int row = Math.abs(toRow - fromRow);
        int col = Math.abs(toCol - fromCol);
        return row == 0 || col == 0;
    }
}
