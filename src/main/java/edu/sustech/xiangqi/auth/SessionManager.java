package edu.sustech.xiangqi.auth;

public class SessionManager {
    // 如果为 null，说明是游客；否则为当前登录的用户名
    private static String currentUser = null;

    public static void login(String username) {
        currentUser = username;
    }

    public static void loginAsGuest() {
        currentUser = null;
    }

    public static boolean isGuest() {
        return currentUser == null;
    }

    public static String getCurrentUser() {
        return currentUser;
    }
}