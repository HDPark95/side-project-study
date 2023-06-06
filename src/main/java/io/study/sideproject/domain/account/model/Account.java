package io.study.sideproject.domain.account.model;

import io.study.sideproject.domain.common.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Account extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private String username;

    private String password;

    private AccounType accountType;

    private String email;

    private String contact;

}
