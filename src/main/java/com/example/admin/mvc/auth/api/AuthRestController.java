package com.example.admin.mvc.auth.api;

import com.example.admin.mvc.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthRestController {
    private final AuthService authService;
    @PostMapping("/email")
    public ResponseEntity email(){
        return ResponseEntity.ok(null);
    }

    @PostMapping("/refresh")
    public ResponseEntity refresh(){
        return ResponseEntity.ok(null);
    }
}
