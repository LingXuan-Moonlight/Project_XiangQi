package edu.sustech.xiangqi.model;

// 保存棋盘数据，并统一检查和执行移动

import edu.sustech.xiangqi.model.Pieces.*;

public class Board {
    // 定义棋盘大小
    public static final int ROWS = 10;
    public static final int COLS = 9;

    // 存储棋子位置
    private final Piece[][] pieces = new Piece[ROWS][COLS];

    public Board() {
        initializePieces();
    }

    private void initializePieces() {
        pieces[9][0] = new RookPiece();
        pieces[9][1] = new HorsePiece();
        pieces[9][2] = new ElephantPiece();
        pieces[9][3] = new AdvisorPiece();
        pieces[9][4] = new GeneralPiece();
        pieces[9][5] = new AdvisorPiece();
        pieces[9][6] = new ElephantPiece();
        pieces[9][7] = new HorsePiece();
        pieces[9][8] = new RookPiece();
        pieces[6][0] = new SoldierPiece();
        pieces[7][1] = new CannonPiece();
        pieces[6][2] = new SoldierPiece();
        pieces[6][4] = new SoldierPiece();
        pieces[6][6] = new SoldierPiece();
        pieces[7][7] = new CannonPiece();
        pieces[6][8] = new SoldierPiece();

        pieces[0][0] = new RookPieceB();
        pieces[0][1] = new HorsePieceB();
        pieces[0][2] = new ElephantPieceB();
        pieces[0][3] = new AdvisorPieceB();
        pieces[0][4] = new GeneralPieceB();
        pieces[0][5] = new AdvisorPieceB();
        pieces[0][6] = new ElephantPieceB();
        pieces[0][7] = new HorsePieceB();
        pieces[0][8] = new RookPieceB();
        pieces[3][0] = new SoldierPieceB();
        pieces[2][1] = new CannonPieceB();
        pieces[3][2] = new SoldierPieceB();
        pieces[3][4] = new SoldierPieceB();
        pieces[3][6] = new SoldierPieceB();
        pieces[2][7] = new CannonPieceB();
        pieces[3][8] = new SoldierPieceB();
    }

    public boolean isInside(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    public Piece getPieceAt(int row, int col) {
        if (!isInside(row, col)) {
            return null;
        }
        return pieces[row][col];
    }

    public boolean tryMove(int fromRow, int fromCol, int toRow, int toCol) {
        if (!isInside(fromRow, fromCol) || !isInside(toRow, toCol)) {
            return false;
        }
        if (fromRow == toRow && fromCol == toCol) {
            return false;
        }

        Piece piece = getPieceAt(fromRow, fromCol);
        if (piece == null) {
            return false;
        }

        // TODO: 加入回合检查，只允许当前一方移动自己的棋子

        boolean capture = false;
        if (getPieceAt(toRow, toCol) != null) {
            if (getPieceAt(toRow, toCol).isRed() == piece.isRed()) {
                return false;
            } else {
                capture = true;
            }
        }

        if (!piece.canMove(this, fromRow, fromCol, toRow, toCol)) {
            return false;
        }

        // TODO: 检查走完后己方将帅是否安全

        if (capture) pieces[toRow][toCol] = null;
        pieces[fromRow][fromCol] = null;
        pieces[toRow][toCol] = piece;

        // TODO: 仅在成功移动后切换回合，并判断将军、胜负等状态
        return true;
    }
}
