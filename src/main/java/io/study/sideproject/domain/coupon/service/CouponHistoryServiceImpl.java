package io.study.sideproject.domain.coupon.service;

import io.study.sideproject.common.exception.CustomException;
import io.study.sideproject.common.exception.ErrorCode;
import io.study.sideproject.domain.account.model.Account;
import io.study.sideproject.domain.coupon.entity.Coupon;
import io.study.sideproject.domain.coupon.entity.CouponHistory;
import io.study.sideproject.domain.coupon.repository.CouponHistoryRepository;
import io.study.sideproject.domain.coupon.repository.CouponRepository;
import io.study.sideproject.domain.coupon.response.CouponHistoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static io.study.sideproject.domain.coupon.entity.CouponHistory.mapToEntity;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class CouponHistoryServiceImpl implements CouponHistoryService {

    private final CouponHistoryRepository couponHistoryRepository;
    private final CouponRepository couponRepository;

    // CouponHistory 생성
    @Transactional
    @Override
    public CouponHistoryResponse createCouponHistory(Long couponId, Account account) {

        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_COUPON));

        CouponHistory couponHistory = mapToEntity(coupon, account);

        CouponHistory saveCouponHistory = couponHistoryRepository.save(couponHistory);

        return CouponHistoryResponse.mapToDto(saveCouponHistory);
    }

    // CouponHistory 삭제 (이력날짜 업데이트)
    @Transactional
    @Override
    public CouponHistoryResponse deleteCouponHistory(Long couponHistoryId) {

        CouponHistory couponHistory = couponHistoryRepository.findById(couponHistoryId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_COUPONHISTORY));

        couponHistory.delete();

        return CouponHistoryResponse.mapToDto(couponHistory);
    }
}
