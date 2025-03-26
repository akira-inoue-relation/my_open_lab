package com.enuzu.app.service.impl;

import com.enuzu.app.model.entity.AccountMaster;
import com.enuzu.app.model.response.AccountMasterResponse;
import com.enuzu.app.repository.AccountMasterRepository;
import com.enuzu.app.service.AccountMasterService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * アカウントマスターサービス実装クラス
 */
@Service
@RequiredArgsConstructor
public class AccountMasterServiceImpl implements AccountMasterService {

    @Autowired
    private AccountMasterRepository accountRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public
    AccountMasterResponse getAccountList(long id) {
        AccountMaster accountMaster = accountRepository.findById((long) id).orElse(null);
        AccountMasterResponse res = new AccountMasterResponse();
        if (accountMaster == null) {
            return null;
        } else {
            res.setId(accountMaster.getId().intValue());
            res.setPersonName(accountMaster.getPersonName());
            res.setPersonNameKana(accountMaster.getPersonNameKana());
            res.setStoreId(accountMaster.getStoreId());
            res.setLoginId(accountMaster.getLoginId());
            res.setAuthority(accountMaster.getAuthority());
            return res;
        }
    }

}
