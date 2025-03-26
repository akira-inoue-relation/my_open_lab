package com.enuzu.app.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * アカウントマスターレスポンスクラス
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountMasterResponse {

    /**
     * ID
     */
    private Integer id;

    /**
     * 氏名
     */
    private String personName;

    /**
     * 氏名カナ
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
     * 権限
     */
    private Integer authority;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonNameKana() {
        return personNameKana;
    }

    public void setPersonNameKana(String personNameKana) {
        this.personNameKana = personNameKana;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}