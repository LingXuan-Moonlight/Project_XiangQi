package edu.sustech.xiangqi.auth;

import java.io.*;
import java.util.Properties;

public class UserService {
    // 文件保存在项目根目录下的 users.properties
    private static final String FILE_PATH = "users.properties";

    // 注册：检查重名 + 写入文件
    public boolean register(String username, String password) {
        Properties props = new Properties();
        File file = new File(FILE_PATH);

        // 1. 读取现有用户
        try (FileInputStream in = new FileInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            // 文件不存在，忽略，第一次注册会新建
        }

        // 2. 检查用户名是否已存在
        if (props.containsKey(username)) {
            return false;
        }

        // 3. 保存新用户
        props.setProperty(username, password);
        try (FileOutputStream out = new FileOutputStream(file)) {
            props.store(out, "User Data");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 登录：验证
    public boolean login(String username, String password) {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(FILE_PATH)) {
            props.load(in);
            // 直接对比明文
            return password.equals(props.getProperty(username));
        } catch (IOException e) {
            return false; // 文件不存在或无此用户
        }
    }
}