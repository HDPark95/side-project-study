package io.study.sideproject.domain.account.dto;

import lombok.Data;

@Data
class AddressDto {
    private String zipCode;
    private String address;
    private String detailAddress;
}
