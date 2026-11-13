package edu.sustech.xiangqi;

import edu.sustech.xiangqi.controller.ChessController;
import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.view.ChessFrame;
import edu.sustech.xiangqi.view.LoginFrame;

import javax.swing.SwingUtilities;

// 程序入口
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true); // 只启动登录界面
        });
    }

    // 登录或游客模式成功后调用
    public static void startGame() {
        SwingUtilities.invokeLater(() -> {
            Board board = new Board();
            ChessFrame frame = new ChessFrame(board);
            ChessController controller = new ChessController(board, frame.getBoardPanel());
            frame.getBoardPanel().addMouseListener(controller);
            frame.setVisible(true);
        });
    }
}
