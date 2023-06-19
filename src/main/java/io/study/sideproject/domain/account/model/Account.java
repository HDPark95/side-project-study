package io.study.sideproject.domain.account.model;

import io.study.sideproject.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@DiscriminatorColumn(name = "account_type")
public abstract class Account extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private String username;

    private String password;

//    @Enumerated(EnumType.STRING)
//    private AccountType accountType;

    private String email;

    private String contact;

    private String name;


    public Account(String username, String password, String email, String contact, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.name = name;
    }
}
