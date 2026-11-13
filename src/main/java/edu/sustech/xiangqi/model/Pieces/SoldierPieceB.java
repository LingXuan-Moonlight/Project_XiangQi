package edu.sustech.xiangqi.model.Pieces;

//黑卒

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

public class SoldierPieceB extends Piece {
    public SoldierPieceB() {
        super("卒", false);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        int row = toRow - fromRow;
        int col = toCol - fromCol;
        if (fromRow <= 4) {
            return col == 0 && row == 1;
        } else {
            return (col == 1 && row == 0) || (col == 0 && row == 1) || (col == -1 && row == 0);
        }
    }
}
