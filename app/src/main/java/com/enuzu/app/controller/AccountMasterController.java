package com.enuzu.app.controller;

import com.enuzu.app.model.response.AccountMasterResponse;
import com.enuzu.app.service.AccountMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * アカウントコントローラー
 */
@RestController
@RequestMapping("/account")
public class AccountMasterController {

    /**
     * アカウントサービス
     */
    @Autowired
    private AccountMasterService accountService;

    /**
     * IDによりアカウントを取得する(Sampleなので削除予定)
     * @param id アカウントID
     * @return アカウント情報
     */
    @GetMapping("/{id}")
    public ResponseEntity<AccountMasterResponse> getAccount(@PathVariable long id) {
        AccountMasterResponse res = accountService.getAccountList(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.badRequest().body(res);
        }
    }
}
