package edu.sustech.xiangqi.view;

import edu.sustech.xiangqi.Main;
import edu.sustech.xiangqi.auth.SessionManager;
import edu.sustech.xiangqi.auth.UserService;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField userField = new JTextField(15);
    private JPasswordField passField = new JPasswordField(15);
    private UserService userService = new UserService();

    public LoginFrame() {
        setTitle("象棋游戏登录");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // UI 组件
        JPanel p1 = new JPanel(); p1.add(new JLabel("用户名:")); p1.add(userField);
        JPanel p2 = new JPanel(); p2.add(new JLabel("密  码:")); p2.add(passField);

        JPanel p3 = new JPanel();
        JButton loginBtn = new JButton("登录");
        JButton regBtn = new JButton("注册");
        JButton guestBtn = new JButton("游客模式");
        p3.add(loginBtn); p3.add(regBtn); p3.add(guestBtn);

        add(p1); add(p2); add(p3);

        // --- 业务逻辑 ---

        // 登录
        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (userService.login(user, pass)) {
                SessionManager.login(user);
                startGame();
            } else {
                JOptionPane.showMessageDialog(this, "用户名或密码错误！");
            }
        });

        // 注册
        regBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "不能为空！");
                return;
            }
            if (userService.register(user, pass)) {
                JOptionPane.showMessageDialog(this, "注册成功，请登录！");
            } else {
                JOptionPane.showMessageDialog(this, "用户名已存在！");
            }
        });

        // 游客
        guestBtn.addActionListener(e -> {
            SessionManager.loginAsGuest();
            startGame();
        });
    }

    private void startGame() {
        this.dispose(); // 关闭登录框
        Main.startGame(); // 调用你的 Main 类启动游戏
    }
}
