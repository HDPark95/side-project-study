package io.study.sideproject.domain.account.service;

import io.study.sideproject.common.TokenInfo;
import io.study.sideproject.domain.account.dto.LoginDto;

public interface AccountService {
    TokenInfo login(LoginDto loginDto);
}
