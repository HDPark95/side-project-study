package io.study.sideproject.domain.coupon.service;

import io.study.sideproject.domain.coupon.request.CouponCreateRequest;
import io.study.sideproject.domain.coupon.request.CouponSearchRequest;
import io.study.sideproject.domain.coupon.request.CouponUpdateRequest;
import io.study.sideproject.domain.coupon.response.CouponResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CouponService {

    // Coupon 생성
    CouponResponse createCoupon(CouponCreateRequest request);

    // Coupon 전체조회(페이징, 검색)
    Page<CouponResponse> getCouponList(Pageable pageable, CouponSearchRequest request);

    // Coupon 단건조회
    CouponResponse getCoupon(Long couponId);

    // Coupon 수정
    CouponResponse updateCoupon(Long couponId, CouponUpdateRequest request);

    // Coupon 삭제
    CouponResponse deleteCoupon(Long couponId);
}
