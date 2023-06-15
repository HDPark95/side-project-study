package io.study.sideproject.domain.coupon.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.study.sideproject.domain.common.Status;
import io.study.sideproject.domain.coupon.entity.Coupon;
import io.study.sideproject.domain.coupon.entity.CouponStatus;
import io.study.sideproject.domain.coupon.entity.CouponType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@ToString
public class CouponResponse {

    private final Long id;
    private final String couponCode;
    private final String couponName;
    private final CouponType couponType;
    private final CouponStatus couponStatus;
    private final Status status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime startAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime endAt;

    @Builder
    public CouponResponse(Long id, String couponCode, String couponName, CouponType couponType, CouponStatus couponStatus, Status status, LocalDateTime startAt, LocalDateTime endAt) {
        this.id = id;
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponType = couponType;
        this.couponStatus = couponStatus;
        this.status = status;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    static public CouponResponse mapToDto(Coupon coupon) {

        return CouponResponse.builder()
                .id(coupon.getId())
                .couponCode(coupon.getCouponCode())
                .couponName(coupon.getCouponName())
                .couponType(coupon.getCouponType())
                .couponStatus(coupon.getCouponStatus())
                .status(coupon.getStatus())
                .startAt(coupon.getStartAt())
                .endAt(coupon.getEndAt())
                .build();
    }
}
