package com.example.admin.mvc.auth.api;

import com.example.admin.constant.RVO;
import com.example.admin.mvc.auth.dto.EmailLoginDTO;
import com.example.admin.mvc.auth.dto.TokenDTO;
import com.example.admin.mvc.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthRestController {
    private final AuthService authService;
    @PostMapping("/email")
    public ResponseEntity<RVO<TokenDTO>> email(@RequestBody EmailLoginDTO emailLoginDTO){
        log.debug("/email emailLoginDTO: {}", emailLoginDTO);
        TokenDTO tokenDto = TokenDTO.builder()
            .accessToken("null")
            .refreshToken("null")
            .build();
        RVO<TokenDTO> rvo = RVO
                    .<TokenDTO>builder()
                    .data(tokenDto)
                    .build();
        return ResponseEntity.ok(rvo);
    }

    @PostMapping("/refresh")
    public ResponseEntity refresh(){
        throw new RuntimeException();
        // return ResponseEntity.ok(null);
    }
}
