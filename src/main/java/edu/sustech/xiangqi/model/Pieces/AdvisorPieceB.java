package edu.sustech.xiangqi.model.Pieces;

// 黑士

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

public class AdvisorPieceB extends Piece {
    public AdvisorPieceB() {
        super("士", false);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // 行和列必须都变化一格，不能直走、原地停留或跨越多格
        if (Math.abs(toRow - fromRow) != 1 || Math.abs(toCol - fromCol) != 1) {
            return false;
        }

        // 列判断
        if (toCol < 3 || toCol > 5) {
            return false;
        }

        // 行判断
        return toRow >= 0 && toRow <= 2;
    }
}
