package io.study.sideproject.domain.coupon.request;

import io.study.sideproject.domain.coupon.entity.CouponStatus;
import io.study.sideproject.domain.coupon.entity.CouponType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CouponSearchRequest {

    private String couponCode;
    private String couponName;
    private CouponType couponType;
    private CouponStatus couponStatus;

    @Builder
    public CouponSearchRequest(String couponCode, String couponName, CouponType couponType, CouponStatus couponStatus) {
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponType = couponType;
        this.couponStatus = couponStatus;
    }
}
