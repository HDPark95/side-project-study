package io.study.sideproject.domain.coupon.controller;

import io.study.sideproject.domain.account.model.Account;
import io.study.sideproject.domain.coupon.response.CouponHistoryResponse;
import io.study.sideproject.domain.coupon.service.CouponHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CouponHistoryController {

    private final CouponHistoryService couponHistoryService;

    // CouponHistory 생성
    @PostMapping("/api/couponsHistory/{couponId}")
    public ResponseEntity<CouponHistoryResponse> createCouponHistory(@PathVariable Long couponId,
                                                                     @AuthenticationPrincipal Account account) {

        log.info("CouponHistoryController createCouponHistory() run");

        CouponHistoryResponse couponHistory = couponHistoryService.createCouponHistory(couponId, account);

        return new ResponseEntity<>(couponHistory, HttpStatus.CREATED);
    }

    // CouponHistory 삭제 (이력날짜 업데이트)
    @PostMapping("/api/couponsHistory/{couponHistoryId}")
    public ResponseEntity<CouponHistoryResponse> deleteCouponHistory(@PathVariable Long couponHistoryId) {

        log.info("CouponHistoryController deleteCouponHistory() run");

        CouponHistoryResponse couponHistory = couponHistoryService.deleteCouponHistory(couponHistoryId);

        return new ResponseEntity<>(couponHistory, HttpStatus.OK);
    }
}
