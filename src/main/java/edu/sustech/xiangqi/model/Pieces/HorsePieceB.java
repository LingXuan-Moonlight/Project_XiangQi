package edu.sustech.xiangqi.model.Pieces;

//黑马

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

public class HorsePieceB extends Piece {
    public HorsePieceB() {
        super("马", false);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        //TODO:blocking horse leg

        int row = Math.abs(toRow - fromRow);
        int col = Math.abs(toCol - fromCol);
        return row == 2 && col == 1 || row == 1 && col == 2;
    }
}
