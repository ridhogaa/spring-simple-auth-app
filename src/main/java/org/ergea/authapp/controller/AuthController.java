package org.ergea.authapp.controller;

import org.ergea.authapp.dto.BaseResponse;
import org.ergea.authapp.dto.UserDTO;
import org.ergea.authapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> login(@RequestBody UserDTO request) {
        return ResponseEntity.ok(BaseResponse.success(authService.login(request), "Success Login User"));
    }
}
