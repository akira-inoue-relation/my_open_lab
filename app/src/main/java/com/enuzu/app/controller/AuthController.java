package com.enuzu.app.controller;

import com.enuzu.app.model.request.LoginRequest;
import com.enuzu.app.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 認証コントローラー
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    /**
     * 認証サービス
     */
    @Autowired
    private AuthService authService;

    /**
     * ログイン認証を行う
     * @param request ログインリクエスト
     * @return 認証結果
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        boolean isAuthenticated = authService.authenticate(request.getLoginId(), request.getPassword());
        
        if (isAuthenticated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
