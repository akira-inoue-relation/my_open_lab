package com.enuzu.app.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * アカウントマスターリクエストクラス
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountMasterRequest {

    /**
     * 氏名
     */
    private String personName;
    
    /**
     * 氏名（カナ）
     */
    private String personNameKana;
    
    /**
     * 店舗ID
     */
    private Integer storeId;
    
    /**
     * ログインID
     */
    private String loginId;
    
    /**
     * パスワード
     */
    private String password;
    
    /**
     * 権限
     */
    private Integer authority;
}
