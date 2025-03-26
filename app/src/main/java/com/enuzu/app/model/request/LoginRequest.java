package com.enuzu.app.model.request;

/**
 * ログインリクエストクラス
 */
public class LoginRequest {

    /**
     * ログインID
     */
    private String loginId;
    
    /**
     * パスワード
     */
    private String password;
    
    /**
     * デフォルトコンストラクタ
     */
    public LoginRequest() {
    }
    
    /**
     * コンストラクタ
     * 
     * @param loginId ログインID
     * @param password パスワード
     */
    public LoginRequest(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
    
    /**
     * ログインIDを取得する
     * 
     * @return ログインID
     */
    public String getLoginId() {
        return loginId;
    }
    
    /**
     * ログインIDを設定する
     * 
     * @param loginId ログインID
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    
    /**
     * パスワードを取得する
     * 
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * パスワードを設定する
     * 
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
