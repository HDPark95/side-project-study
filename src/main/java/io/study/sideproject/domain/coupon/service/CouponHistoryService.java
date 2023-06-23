package io.study.sideproject.domain.coupon.service;

import io.study.sideproject.domain.account.model.Account;
import io.study.sideproject.domain.coupon.response.CouponHistoryResponse;

public interface CouponHistoryService {

    // CouponHistory 생성
    CouponHistoryResponse createCouponHistory(Long couponId, Account account);

    // CouponHistory 삭제 (이력날짜 업데이트)
    CouponHistoryResponse deleteCouponHistory(Long couponHistoryId);
}
