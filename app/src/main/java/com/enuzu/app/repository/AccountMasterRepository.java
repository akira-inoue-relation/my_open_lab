package com.enuzu.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enuzu.app.model.entity.AccountMaster;

public interface AccountMasterRepository extends JpaRepository<AccountMaster, Long> {
    List<AccountMaster> findByLoginId(String loginId);
}
