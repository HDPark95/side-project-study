package io.study.sideproject.domain.common;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String zipCode;
    private String address;
    private String detailAddress;
}
