package com.enuzu.app.service;

import com.enuzu.app.model.response.AccountMasterResponse;

/**
 * アカウントマスターサービスインターフェース
 */
public interface AccountMasterService {
    
    /**
     * 全てのアカウントを取得する
     * @return アカウントリスト
     */
    AccountMasterResponse getAccountList(long id);
    
}
