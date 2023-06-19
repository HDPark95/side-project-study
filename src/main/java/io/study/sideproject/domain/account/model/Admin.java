package io.study.sideproject.domain.account.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
public class Admin extends Account{

    @Builder
    public Admin(String username, String password, String email, String contact, String name){
        super(username, password, email, contact, name);
    }
}
