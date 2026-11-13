package edu.sustech.xiangqi.view;

import edu.sustech.xiangqi.model.Board;

import javax.swing.*;

public final class ChessFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private final BoardPanel boardPanel;

    public ChessFrame(Board board) {
        super("中国象棋");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardPanel = new BoardPanel(board);
        boardPanel.setLayout(null);  // 关键：关闭布局管理器

        setContentPane(boardPanel);
        setSize(1000,1000);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }
}
//TODO:游客模式下禁用存档功能
//TODO:多用户存档隔离