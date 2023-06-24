package io.study.sideproject.domain.account.model;

import io.study.sideproject.domain.common.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
public class Seller extends Account{

    @Embedded
    @AttributeOverride(name = "zipCode", column = @javax.persistence.Column(name = "return_zip_code"))
    @AttributeOverride(name = "zipCode", column = @javax.persistence.Column(name = "seller_zip_code"))
    @AttributeOverride(name = "zipCode", column = @javax.persistence.Column(name = "seller_zip_code"))
    Address retrunAddress;

    @Embedded
    @AttributeOverride(name = "zipCode", column = @javax.persistence.Column(name = "seller_zip_code"))
    @AttributeOverride(name = "zipCode", column = @javax.persistence.Column(name = "seller_zip_code"))
    @AttributeOverride(name = "zipCode", column = @javax.persistence.Column(name = "seller_zip_code"))
    Address businessAddress;

    @Builder
    public Seller(String username, String password, String email, String contact, String name, Address returnAddress, Address businessAddress){
        super(username, password, email, contact, name);
        this.retrunAddress = returnAddress;
        this.businessAddress = businessAddress;
    }
}
