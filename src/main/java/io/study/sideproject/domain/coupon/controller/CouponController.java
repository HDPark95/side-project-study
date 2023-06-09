package io.study.sideproject.domain.coupon.controller;

import io.study.sideproject.domain.coupon.request.CouponCreateRequest;
import io.study.sideproject.domain.coupon.request.CouponUpdateRequest;
import io.study.sideproject.domain.coupon.response.CouponResponse;
import io.study.sideproject.domain.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    // 쿠폰생성
    @PostMapping("/api/coupons")
    public ResponseEntity<CouponResponse> createCoupon(@RequestBody CouponCreateRequest request) {
        log.info("CouponController createCoupon() run");

        CouponResponse createCoupon = couponService.createCoupon(request);
        log.info("createCoupon : {}", createCoupon);

        return new ResponseEntity<>(createCoupon, HttpStatus.CREATED);
    }

    @PatchMapping("/api/coupons/{couponId}")
    public ResponseEntity<CouponResponse> updateCoupon(@PathVariable Long couponId,
                             @RequestBody CouponUpdateRequest request) {
        log.info("CouponController updateCoupon() run");

        CouponResponse updateCoupon = couponService.updateCoupon(couponId, request);

        return new ResponseEntity<>(updateCoupon, HttpStatus.OK);
    }
}
