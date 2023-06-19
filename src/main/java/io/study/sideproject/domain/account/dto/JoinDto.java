package io.study.sideproject.domain.account.dto;

import io.study.sideproject.domain.account.model.AccountType;
import io.study.sideproject.domain.account.model.Admin;
import io.study.sideproject.domain.account.model.Client;
import io.study.sideproject.domain.account.model.Seller;
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

    public Seller joinSeller(){
        return Seller.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .contact(contact)
                .build();
    }

    public Client joinClient(){
        return Client.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .contact(contact)
                .build();
    }

    public Admin joinAdmin(){
        return Admin.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .contact(contact)
                .build();
    }

}
