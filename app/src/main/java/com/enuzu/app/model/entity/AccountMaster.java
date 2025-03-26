package com.enuzu.app.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * アカウントマスターエンティティ
 */
@Entity
@Table(name = "account_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountMaster {

    @Id
    private Integer id;

    private String personName;

    private String personNameKana;

    private Integer storeId;

    private String loginId;

    private String password;

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
        this.personName = personName == null ? null : personName.trim();
    }

    public String getPersonNameKana() {
        return personNameKana;
    }

    public void setPersonNameKana(String personNameKana) {
        this.personNameKana = personNameKana == null ? null : personNameKana.trim();
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
        this.loginId = loginId == null ? null : loginId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}
