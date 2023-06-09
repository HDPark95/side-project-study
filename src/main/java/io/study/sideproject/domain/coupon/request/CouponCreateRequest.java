package io.study.sideproject.domain.coupon.request;

import io.study.sideproject.domain.coupon.entity.CouponType;
import lombok.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CouponCreateRequest {

    @NotBlank(message = "쿠폰 코드는 필수로 입력해야합니다.")
    private String couponCode;

    @NotBlank(message = "쿠폰 이름은 필수로 입력해야합니다.")
    private String couponName;

    @NotBlank(message = "쿠폰타입을 금액 or 비율 중에서 하나로 선택해야합니다.")
    private CouponType couponType;

    /*
    private CouponStatus couponStatus;  // Coupon엔티티의 mapToEntity() 메서드에서 default값으로 UNUSED를 넣어줌
    */

    @Builder
    public CouponCreateRequest(String couponCode, String couponName, CouponType couponType) {
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponType = couponType;
    }
}
