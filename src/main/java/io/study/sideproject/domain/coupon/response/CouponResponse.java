package io.study.sideproject.domain.coupon.response;

import io.study.sideproject.domain.coupon.entity.Coupon;
import io.study.sideproject.domain.coupon.entity.CouponStatus;
import io.study.sideproject.domain.coupon.entity.CouponType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CouponResponse {

    private Long id;
    private String couponCode;
    private String couponName;
    private CouponType couponType;
    private CouponStatus couponStatus;

    @Builder
    public CouponResponse(Long id, String couponCode, String couponName, CouponType couponType, CouponStatus couponStatus) {
        this.id = id;
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponType = couponType;
        this.couponStatus = couponStatus;
    }

    static public CouponResponse mapToDto(Coupon coupon) {

        return CouponResponse.builder()
                .id(coupon.getId())
                .couponCode(coupon.getCouponCode())
                .couponName(coupon.getCouponName())
                .couponType(coupon.getCouponType())
                .couponStatus(coupon.getCouponStatus())
                .build();
    }
}
