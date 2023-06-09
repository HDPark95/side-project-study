package io.study.sideproject.domain.coupon.request;

import io.study.sideproject.domain.coupon.entity.CouponStatus;
import io.study.sideproject.domain.coupon.entity.CouponType;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CouponUpdateRequest {

    @NotBlank(message = "쿠폰 코드는 필수로 입력해야합니다.")
    private String couponCode;

    @NotBlank(message = "쿠폰 이름은 필수로 입력해야합니다.")
    private String couponName;

    @NotBlank(message = "AMOUNT(금액) or PERCENTAGE(비율) 중에서 1개를 선택해야합니다.")
    private CouponType couponType;

    @NotBlank(message = "USED(사용), UNUSED(미사용), EXPIRED(만료) 중에서 1개를 선택해야합니다.")
    private CouponStatus couponStatus;

    @Builder
    public CouponUpdateRequest(String couponCode, String couponName, CouponType couponType, CouponStatus couponStatus) {
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponType = couponType;
        this.couponStatus = couponStatus;
    }
}
