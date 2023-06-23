package io.study.sideproject.domain.coupon.response;

import io.study.sideproject.domain.account.model.Account;
import io.study.sideproject.domain.coupon.entity.Coupon;
import io.study.sideproject.domain.coupon.entity.CouponHistory;
import io.study.sideproject.domain.coupon.entity.CouponStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@ToString
public class CouponHistoryResponse {

    private Long id;
    private CouponStatus couponStatus;
    private LocalDateTime usedDate;
    private LocalDateTime deletedDate;
    private Coupon coupon;
    private Account account;

    @Builder
    public CouponHistoryResponse(Long id, CouponStatus couponStatus, LocalDateTime usedDate, LocalDateTime deletedDate, Coupon coupon, Account account) {
        this.id = id;
        this.couponStatus = couponStatus;
        this.usedDate = usedDate;
        this.deletedDate = deletedDate;
        this.coupon = coupon;
        this.account = account;
    }

    static public CouponHistoryResponse mapToDto(CouponHistory couponHistory) {
        return CouponHistoryResponse.builder()
                .id(couponHistory.getId())
                .couponStatus(couponHistory.getCouponStatus())
                .usedDate(couponHistory.getUsedDate())
                .deletedDate(couponHistory.getDeletedDate())
                .coupon(couponHistory.getCoupon())
                .account(couponHistory.getAccount())
                .build();
    }

}
