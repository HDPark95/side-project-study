package io.study.sideproject.domain.account.model;


import io.study.sideproject.domain.common.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class Client extends Account {

    @Embedded
    @AttributeOverride(name = "zipCode", column = @javax.persistence.Column(name = "delivery_zip_code"))
    @AttributeOverride(name = "address", column = @javax.persistence.Column(name = "delivery_address"))
    @AttributeOverride(name = "detailAddress", column = @javax.persistence.Column(name = "delivery_detail_address"))
    Address deliveryAddress;

    @Builder
    public Client(String username, String password, String email, String contact, String name, Address deliveryAddress) {
        super(username, password, email, contact, name);
        this.deliveryAddress = deliveryAddress;
    }
}
