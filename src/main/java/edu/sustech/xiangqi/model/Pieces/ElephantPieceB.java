package edu.sustech.xiangqi.model.Pieces;

//黑象

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

public class ElephantPieceB extends Piece {
    public ElephantPieceB() {
        super("象", false);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        //TODO:other piece has blocked the path of elephant

        int row = Math.abs(toRow - fromRow);
        int col = Math.abs(toCol - fromCol);
        if (row != 2 || col != 2) {
            return false;
        }

        if (toCol < 0 || toCol > 8) {
            return false;
        }

        return toRow >= 0 && toRow <= 4;
    }
}
