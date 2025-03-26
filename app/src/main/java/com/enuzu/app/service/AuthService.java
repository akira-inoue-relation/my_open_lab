package com.enuzu.app.service;

/**
 * 認証サービスインターフェース
 */
public interface AuthService {
    
    /**
     * ユーザー認証を行う
     * @param loginId ログインID
     * @param password パスワード
     * @return 認証結果
     */
    boolean authenticate(String loginId, String password);
}
