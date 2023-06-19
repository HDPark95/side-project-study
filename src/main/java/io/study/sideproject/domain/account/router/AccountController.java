package io.study.sideproject.domain.account.router;

import io.study.sideproject.common.TokenInfo;
import io.study.sideproject.domain.account.dto.JoinDto;
import io.study.sideproject.domain.account.dto.LoginDto;
import io.study.sideproject.domain.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    @PostMapping("/login")
    public ResponseEntity<TokenInfo> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(accountService.login(loginDto));
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto joinDto) {
        accountService.join(joinDto);
        return ResponseEntity.ok("회원가입에 성공하였습니다.");
    }
}
