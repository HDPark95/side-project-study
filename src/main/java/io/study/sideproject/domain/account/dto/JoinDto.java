package io.study.sideproject.domain.account.dto;

import io.study.sideproject.domain.account.model.AccountType;
import lombok.Data;

@Data
public class JoinDto {

    private String username;

    private String password;

    private String email;

    private String name;

    private String contact;

    private AccountType accountType;

    private SellerAdditionalInfoDto sellerAdditionalInfoDto;

    private UserAdditionalInfoDto userAdditionalInfoDto;
}
