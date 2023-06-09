package io.study.sideproject.domain.coupon.controller;

import io.study.sideproject.domain.coupon.request.CouponCreateRequest;
import io.study.sideproject.domain.coupon.request.CouponSearchRequest;
import io.study.sideproject.domain.coupon.request.CouponUpdateRequest;
import io.study.sideproject.domain.coupon.response.CouponResponse;
import io.study.sideproject.domain.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    // Coupon 생성
    @PostMapping("/api/coupons")
    public ResponseEntity<CouponResponse> createCoupon(@RequestBody CouponCreateRequest request) {
        log.info("CouponController createCoupon() run");

        CouponResponse createCoupon = couponService.createCoupon(request);
        log.info("createCoupon : {}", createCoupon);

        return new ResponseEntity<>(createCoupon, HttpStatus.CREATED);
    }

    // Coupon 전체조회(페이징, 검색)
    @GetMapping("/api/coupons")
    public ResponseEntity<Page<CouponResponse>> getCouponList(
                                                              @PageableDefault(page = 0, size = 10) Pageable pageable,
                                                              @Valid CouponSearchRequest request
                                                              ) {
        log.info("CouponController getCouponList() run");

        Page<CouponResponse> couponList = couponService.getCouponList(pageable, request);

        return ResponseEntity.ok(couponList);
    }

    // Coupon 단건조회
    @GetMapping("/api/coupons/{couponId}")
    public ResponseEntity<CouponResponse> getCoupon(@PathVariable Long couponId) {
        log.info("CouponController getCoupon() run");

        CouponResponse coupon = couponService.getCoupon(couponId);

        return ResponseEntity.ok(coupon);
    }

    // Coupon 수정
    @PatchMapping("/api/coupons/{couponId}")
    public ResponseEntity<CouponResponse> updateCoupon(@PathVariable Long couponId,
                             @RequestBody CouponUpdateRequest request) {
        log.info("CouponController updateCoupon() run");

        CouponResponse updateCoupon = couponService.updateCoupon(couponId, request);

        return new ResponseEntity<>(updateCoupon, HttpStatus.OK);
    }

    // Coupon 삭제
    @PatchMapping("/api/coupons/edit/{couponId}")
    public ResponseEntity<CouponResponse> deleteCoupon(@PathVariable Long couponId) {
        log.info("CouponController deleteCoupon() run");

        CouponResponse deleteCoupon = couponService.deleteCoupon(couponId);

        return new ResponseEntity<>(deleteCoupon, HttpStatus.OK);
    }

}
