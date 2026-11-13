package edu.sustech.xiangqi.model.Pieces;

//红相

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

public class ElephantPiece extends Piece {
    public ElephantPiece() {
        super("相", true);
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

        return toRow >= 5 && toRow <= 9;
    }
}
