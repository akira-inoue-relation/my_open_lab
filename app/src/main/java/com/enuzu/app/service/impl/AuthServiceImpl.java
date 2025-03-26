package com.enuzu.app.service.impl;

import com.enuzu.app.model.entity.AccountMaster;
import com.enuzu.app.repository.AccountMasterRepository;
import com.enuzu.app.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 認証サービス実装クラス
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AccountMasterRepository accountRepository;
    
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean authenticate(String loginId, String password) {
        List<AccountMaster> accounts = accountRepository.findByLoginId(loginId);
        
        for (AccountMaster account : accounts) {
            if (passwordEncoder.matches(password, account.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
