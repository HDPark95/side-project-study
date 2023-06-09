package io.study.sideproject.domain.coupon.service;

import io.study.sideproject.domain.coupon.request.CouponCreateRequest;
import io.study.sideproject.domain.coupon.request.CouponUpdateRequest;
import io.study.sideproject.domain.coupon.response.CouponResponse;

public interface CouponService {

    // Coupon 생성
    CouponResponse createCoupon(CouponCreateRequest request);

    CouponResponse updateCoupon(Long couponId, CouponUpdateRequest request);
}
