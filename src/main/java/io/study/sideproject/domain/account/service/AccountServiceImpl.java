package io.study.sideproject.domain.account.service;

import io.study.sideproject.common.JwtTokenProvider;
import io.study.sideproject.common.TokenInfo;
import io.study.sideproject.domain.account.dto.JoinDto;
import io.study.sideproject.domain.account.model.Account;
import io.study.sideproject.domain.account.dto.LoginDto;
import io.study.sideproject.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService{

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final JwtTokenProvider jwtTokenProvider;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository
                .findByUsername(username)
                .map(this::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

    private UserDetails toUserDetails(Account account){
        return User.builder()
                .username(account.getUsername())
                .password(passwordEncoder.encode(account.getPassword()))
                .build();
    }

    @Override
    public TokenInfo login(LoginDto loginDto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(token);
        return jwtTokenProvider.generateToken(authentication);
    }

    @Override
    public void join(JoinDto joinDto) {
        Account account;
        switch (joinDto.getAccountType()){
            case SELLER:
                account = joinDto.joinSeller();
                break;
            case CLIENT:
                account = joinDto.joinClient();
                break;
            case ADMIN:
                account = joinDto.joinAdmin();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + joinDto.getAccountType());
        }
        accountRepository.save(account);
    }

}
