package edu.sustech.xiangqi.model.Pieces;

//黑将

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

public class GeneralPieceB extends Piece {
    public GeneralPieceB() {
        super("将", false);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        int row = Math.abs(toRow - fromRow);
        int col = Math.abs(toCol - fromCol);
        if (!((row == 1 && col == 0) || (row == 0 && col == 1))) {
            return false;
        }

        //TODO:facing generals

        if (toCol < 3 || toCol > 5) {
            return false;
        }

        return toRow >= 0 && toRow <= 2;
    }
}
